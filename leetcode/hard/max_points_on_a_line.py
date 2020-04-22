'''
https://leetcode.com/problems/max-points-on-a-line/
'''

class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        def compute_gradient(x1, x2, y1, y2):
            gradient = 0
            if points[i][0] != points[j][0]:  
                gradient = (points[i][1] - points[j][1]) * 200 / (points[i][0] - points[j][0])
            return gradient
        
        if len(points) == 0:
            return 0
        result = 0
        for i in range(len(points)):
            numCountsByGradient = {}
            numSamePoints = 0
            for j in range(i + 1, len(points)):
                if points[i][0] == points[j][0] and points[i][1] == points[j][1]:
                    numSamePoints += 1
                    continue
                gradient = compute_gradient(points[i][0], points[i][1], points[j][0], points[j][1])
                if gradient in numCountsByGradient:
                    numCountsByGradient[gradient] += 1
                else:
                    numCountsByGradient[gradient] = 1
            for key in numCountsByGradient:
                result = max(result, numCountsByGradient[key] + numSamePoints)
            if numCountsByGradient == {}:
                result = max(result, numSamePoints)
        return result + 1
