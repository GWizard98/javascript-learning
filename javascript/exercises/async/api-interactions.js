/**
 * Async JavaScript - Real-World API Interactions
 * 
 * These exercises simulate real API calls and async patterns you'll use daily.
 * Perfect for learning promises, async/await, and error handling patterns.
 */

/**
 * 1. User Profile Fetcher
 * Simulate fetching user data from multiple endpoints
 * 
 * @param {number} userId - User ID to fetch
 * @returns {Promise<Object>} - Complete user profile with posts and friends
 */
async function fetchCompleteUserProfile(userId) {
    // TODO: Fetch user basic info, posts, and friends concurrently
    // Simulate API calls with delays
    // Handle errors gracefully and provide fallback data
    // Expected: Use Promise.all() for concurrent requests
    
    // Simulated API endpoints:
    // fetchUserInfo(userId) - returns {id, name, email}
    // fetchUserPosts(userId) - returns [{id, title, content}...]
    // fetchUserFriends(userId) - returns [{id, name}...]
}

/**
 * 2. Retry Logic Implementation
 * Implement robust retry logic for unreliable APIs
 * 
 * @param {Function} apiCall - Function that returns a Promise
 * @param {number} maxRetries - Maximum number of retry attempts
 * @param {number} delay - Delay between retries in milliseconds
 * @returns {Promise} - Result of successful API call
 */
async function withRetry(apiCall, maxRetries = 3, delay = 1000) {
    // TODO: Implement exponential backoff retry logic
    // Retry on network errors but not on 4xx client errors
    // Log each attempt for debugging
    // Throw original error after max retries exceeded
}

/**
 * 3. Batch API Processor
 * Process large datasets by batching API calls
 * 
 * @param {Array} items - Array of items to process
 * @param {Function} processor - Async function to process each item
 * @param {number} batchSize - Number of items to process concurrently
 * @returns {Promise<Array>} - Array of processed results
 */
async function processBatch(items, processor, batchSize = 5) {
    // TODO: Process items in batches to avoid overwhelming the API
    // Maintain order of results
    // Handle individual item failures without stopping the batch
    // Return both successful results and errors
}

/**
 * 4. Cache-First Data Fetcher
 * Implement caching strategy for API responses
 * 
 * @param {string} cacheKey - Unique key for cached data
 * @param {Function} fetcher - Function that fetches fresh data
 * @param {number} ttl - Time to live in milliseconds
 * @returns {Promise} - Cached or fresh data
 */
async function getCachedData(cacheKey, fetcher, ttl = 300000) { // 5 minutes default
    // TODO: Check cache first, return if valid and not expired
    // If cache miss or expired, fetch fresh data
    // Update cache with fresh data
    // Handle cache errors gracefully
    
    // Use a simple Map for caching: new Map()
    // Cache entry format: {data, timestamp}
}

/**
 * 5. Progress Tracking Uploader
 * Upload files with progress tracking and error recovery
 * 
 * @param {Array} files - Array of file objects to upload
 * @param {Function} onProgress - Callback for progress updates
 * @returns {Promise<Array>} - Array of upload results
 */
async function uploadFilesWithProgress(files, onProgress) {
    // TODO: Upload files one by one (not concurrently for this exercise)
    // Call onProgress with {completed, total, currentFile, overallPercent}
    // Implement pause/resume capability
    // Handle upload failures with retry options
    // Return detailed results for each file
}

/**
 * 6. Race Condition Handler  
 * Handle race conditions in async operations
 * 
 * @param {string} resourceId - ID of the resource being accessed
 * @param {Function} operation - Async operation to perform
 * @returns {Promise} - Result of the operation
 */
async function withRaceConditionProtection(resourceId, operation) {
    // TODO: Prevent concurrent operations on the same resource
    // Use a Map to track ongoing operations
    // Queue subsequent requests for the same resource
    // Clean up after operation completes
    // Handle operation failures properly
}

/**
 * 7. Timeout and Cancellation
 * Add timeout and cancellation support to async operations
 * 
 * @param {Promise} promise - Promise to wrap with timeout
 * @param {number} timeoutMs - Timeout in milliseconds
 * @param {AbortController} controller - Optional abort controller
 * @returns {Promise} - Promise that rejects on timeout or abortion
 */
async function withTimeout(promise, timeoutMs, controller = null) {
    // TODO: Race the original promise against a timeout
    // Support AbortController for manual cancellation
    // Clean up timeout if promise resolves first
    // Provide meaningful error messages for timeouts vs cancellation
}

/**
 * 8. Sequential vs Parallel Execution
 * Compare different execution strategies for async operations
 * 
 * @param {Array} tasks - Array of async functions
 * @param {string} strategy - 'sequential' | 'parallel' | 'limited-parallel'
 * @param {number} limit - Concurrency limit for limited-parallel
 * @returns {Promise<Object>} - Execution results with timing
 */
async function executeTasks(tasks, strategy = 'parallel', limit = 3) {
    // TODO: Implement three different execution strategies
    // Sequential: one after another
    // Parallel: all at once with Promise.all()
    // Limited Parallel: max N concurrent operations
    // Return results with timing information and strategy used
}

// Helper functions for simulation (don't implement these, they're provided)
const simulatedAPI = {
    fetchUserInfo: (userId) => new Promise(resolve => 
        setTimeout(() => resolve({id: userId, name: 'User ' + userId, email: `user${userId}@example.com`}), 100)
    ),
    
    fetchUserPosts: (userId) => new Promise(resolve => 
        setTimeout(() => resolve([{id: 1, title: 'Post 1', content: 'Content 1'}]), 150)
    ),
    
    fetchUserFriends: (userId) => new Promise(resolve => 
        setTimeout(() => resolve([{id: userId + 1, name: 'Friend 1'}]), 120)
    ),
    
    unreliableAPI: () => new Promise((resolve, reject) => 
        Math.random() > 0.7 ? resolve('Success!') : reject(new Error('Network error'))
    )
};

module.exports = {
    fetchCompleteUserProfile,
    withRetry,
    processBatch,
    getCachedData,
    uploadFilesWithProgress,
    withRaceConditionProtection,
    withTimeout,
    executeTasks,
    simulatedAPI
};