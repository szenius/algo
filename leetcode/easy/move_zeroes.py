'''
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
'''


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        p1 = 0  # look at each element of nums
        p2 = 1  # point to 0 nearest to p1, should always be ahead of p1

        while p2 < len(nums):
            while p2 < len(nums) - 1 and nums[p2] == 0:
                p2 += 1
            if nums[p1] == 0:
                nums[p1], nums[p2] = nums[p2], nums[p1]
                p2 += 1
            p1 += 1
            while p1 >= p2:
                p2 += 1
