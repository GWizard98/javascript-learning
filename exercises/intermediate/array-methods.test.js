const {
    transformUsersForUI,
    calculateCartTotal,
    groupSalesData,
    smartSearch,
    validateFormData,
    processApiResponses
} = require('./array-methods');

describe('Intermediate Array Methods', () => {
    
    describe('transformUsersForUI', () => {
        const sampleUsers = [
            { id: 1, name: 'John Doe', email: 'john@example.com', age: 25, isActive: true },
            { id: 2, name: 'Jane Smith', email: 'jane@example.com', age: 35, isActive: false },
            { id: 3, name: 'Alice Johnson', email: 'alice@example.com', age: 28, isActive: true },
            { id: 4, name: 'Bob Wilson', email: 'bob@example.com', age: 22, isActive: true }
        ];

        test('should filter active users and sort by name', () => {
            const result = transformUsersForUI(sampleUsers);
            expect(result).toHaveLength(3);
            expect(result[0].name).toBe('Alice Johnson');
            expect(result[1].name).toBe('Bob Wilson');
            expect(result[2].name).toBe('John Doe');
        });

        test('should format display names based on age', () => {
            const result = transformUsersForUI(sampleUsers);
            expect(result.find(u => u.name === 'John Doe').displayName).toBe('John Doe (25)');
            expect(result.find(u => u.name === 'Alice Johnson').displayName).toBe('Alice Johnson (28)');
        });

        test('should handle empty array', () => {
            const result = transformUsersForUI([]);
            expect(result).toEqual([]);
        });

        test('should handle users over 30', () => {
            const olderUsers = [
                { id: 1, name: 'Senior Dev', email: 'senior@example.com', age: 45, isActive: true }
            ];
            const result = transformUsersForUI(olderUsers);
            expect(result[0].displayName).toBe('Senior Dev');
        });
    });

    describe('calculateCartTotal', () => {
        const sampleCart = [
            { name: 'Laptop', price: 999.99, quantity: 1, category: 'electronics' },
            { name: 'Mouse', price: 25.50, quantity: 2, category: 'electronics' },
            { name: 'Book', price: 15.99, quantity: 3, category: 'books' }
        ];

        test('should calculate correct totals without discount', () => {
            const result = calculateCartTotal(sampleCart);
            expect(result.subtotal).toBeCloseTo(1098.96, 2);
            expect(result.discount).toBe(0);
            expect(result.tax).toBeCloseTo(87.92, 2);
            expect(result.total).toBeCloseTo(1186.88, 2);
            expect(result.itemCount).toBe(6);
        });

        test('should apply discount correctly', () => {
            const result = calculateCartTotal(sampleCart, 10);
            expect(result.discount).toBeCloseTo(109.90, 2);
            expect(result.total).toBeCloseTo(1068.19, 2);
        });

        test('should handle empty cart', () => {
            const result = calculateCartTotal([]);
            expect(result.subtotal).toBe(0);
            expect(result.total).toBe(0);
            expect(result.itemCount).toBe(0);
        });

        test('should use default parameters', () => {
            const result = calculateCartTotal(sampleCart);
            expect(result.discount).toBe(0);
            expect(result.tax).toBeGreaterThan(0);
        });
    });

    describe('groupSalesData', () => {
        const sampleSales = [
            { product: 'Widget A', amount: 100, date: '2024-01-15', region: 'North' },
            { product: 'Widget B', amount: 200, date: '2024-01-16', region: 'North' },
            { product: 'Widget A', amount: 150, date: '2024-02-15', region: 'South' },
            { product: 'Widget C', amount: 75, date: '2024-01-17', region: 'North' }
        ];

        test('should group by region', () => {
            const result = groupSalesData(sampleSales, 'region');
            expect(result.North.total).toBe(375);
            expect(result.North.count).toBe(3);
            expect(result.South.total).toBe(150);
            expect(result.South.count).toBe(1);
        });

        test('should group by product', () => {
            const result = groupSalesData(sampleSales, 'product');
            expect(result['Widget A'].total).toBe(250);
            expect(result['Widget A'].count).toBe(2);
            expect(result['Widget B'].total).toBe(200);
            expect(result['Widget B'].count).toBe(1);
        });

        test('should handle empty data', () => {
            const result = groupSalesData([], 'region');
            expect(result).toEqual({});
        });
    });

    describe('smartSearch', () => {
        const sampleItems = [
            { id: 1, name: 'JavaScript Guide', description: 'Complete guide to modern JavaScript' },
            { id: 2, name: 'Python Basics', description: 'Learn Python programming fundamentals' },
            { id: 3, name: 'Web Development', description: 'HTML, CSS, and JavaScript for beginners' },
            { id: 4, name: 'Advanced JS', description: 'Advanced JavaScript patterns and techniques' }
        ];

        test('should find items matching search term', () => {
            const result = smartSearch(sampleItems, 'JavaScript', ['name', 'description']);
            expect(result).toHaveLength(3);
            expect(result.some(item => item.id === 1)).toBe(true);
            expect(result.some(item => item.id === 3)).toBe(true);
            expect(result.some(item => item.id === 4)).toBe(true);
        });

        test('should be case insensitive', () => {
            const result = smartSearch(sampleItems, 'javascript', ['name', 'description']);
            expect(result.length).toBeGreaterThan(0);
        });

        test('should search in specified fields only', () => {
            const result = smartSearch(sampleItems, 'Python', ['name']);
            expect(result).toHaveLength(1);
            expect(result[0].id).toBe(2);
        });

        test('should return empty array for no matches', () => {
            const result = smartSearch(sampleItems, 'Ruby', ['name', 'description']);
            expect(result).toEqual([]);
        });
    });

    describe('validateFormData', () => {
        test('should validate required fields', () => {
            const formData = [
                { field: 'email', value: '', rules: ['required', 'email'] },
                { field: 'name', value: 'John', rules: ['required'] }
            ];
            const result = validateFormData(formData);
            expect(result.isValid).toBe(false);
            expect(result.errors).toContain('email is required');
        });

        test('should validate email format', () => {
            const formData = [
                { field: 'email', value: 'invalid-email', rules: ['email'] }
            ];
            const result = validateFormData(formData);
            expect(result.isValid).toBe(false);
            expect(result.errors).toContain('email must be a valid email address');
        });

        test('should validate minimum length', () => {
            const formData = [
                { field: 'password', value: '123', rules: ['minLength:8'] }
            ];
            const result = validateFormData(formData);
            expect(result.isValid).toBe(false);
            expect(result.errors).toContain('password must be at least 8 characters');
        });

        test('should return valid result for good data', () => {
            const formData = [
                { field: 'email', value: 'test@example.com', rules: ['required', 'email'] },
                { field: 'name', value: 'John Doe', rules: ['required'] }
            ];
            const result = validateFormData(formData);
            expect(result.isValid).toBe(true);
            expect(result.errors).toEqual([]);
            expect(result.cleanData.email).toBe('test@example.com');
        });
    });

    describe('processApiResponses', () => {
        const sampleResponses = [
            { status: 'success', data: { value: 10 } },
            { status: 'error', error: 'Network timeout' },
            { status: 'success', data: { value: 20 } },
            { status: 'success', data: null },
            { status: 'success', data: { value: 30 } }
        ];

        const doubleValue = (response) => response.data.value * 2;

        test('should process only successful responses', () => {
            const result = processApiResponses(sampleResponses, doubleValue);
            expect(result.filter(r => r !== null)).toHaveLength(3);
        });

        test('should apply processor function correctly', () => {
            const result = processApiResponses(sampleResponses, doubleValue);
            const validResults = result.filter(r => r !== null);
            expect(validResults).toContain(20);
            expect(validResults).toContain(40);
            expect(validResults).toContain(60);
        });

        test('should handle processing errors gracefully', () => {
            const failingProcessor = (response) => {
                if (response.data.value === 20) throw new Error('Processing failed');
                return response.data.value;
            };
            const result = processApiResponses(sampleResponses, failingProcessor);
            expect(result.some(r => r === null)).toBe(true);
        });

        test('should include timing information', () => {
            const result = processApiResponses(sampleResponses, doubleValue);
            expect(typeof result.processingTime).toBe('number');
            expect(result.processingTime).toBeGreaterThan(0);
        });
    });
});