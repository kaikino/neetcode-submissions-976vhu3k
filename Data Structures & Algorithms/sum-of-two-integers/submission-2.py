class Solution:
    def getSum(self, a: int, b: int) -> int:
        # 32-bit mask (all 1s for 32 bits)
        mask = 0xFFFFFFFF
        
        while b != 0:
            # ^ (XOR) calculates the sum without carries
            # & mask ensures we stay within 32-bit boundaries
            temp_sum = (a ^ b) & mask
            
            # & (AND) finds where the carries are, then we shift them left
            carry = ((a & b) << 1) & mask
            
            a = temp_sum
            b = carry
        
        # If 'a' is within the positive range (0 to 2^31 - 1), return it
        # If the 31st bit is 1, it's a negative number in 32-bit logic
        return a if a <= 0x7FFFFFFF else ~(a ^ mask)