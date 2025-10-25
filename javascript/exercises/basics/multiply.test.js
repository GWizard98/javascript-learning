const multiply = require("./multiply");

test("multiplies 3 * 4 to equal 12", () => {
  expect(multiply(3, 4)).toBe(12);
});

test("multiplies 7 * 6 to equal 42", () => {
  expect(multiply(7, 6)).toBe(42);
});
