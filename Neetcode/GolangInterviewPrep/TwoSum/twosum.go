package TwoSum

import "slices"

type TwoSum struct {
	items []int
}



func New() TwoSum {
	return TwoSum{
		items: []int{},
	}
}

func (t *TwoSum) Add(val ...int) {
	t.items = append(t.items, val...)
}

func (t *TwoSum) Find(target int) []int {

	sumMap := make(map[int]int)
	for i := range t.items {
		sumMap[t.items[i]] = i
	}

	for i := range t.items {
		diff := target - t.items[i]
		val, ok := sumMap[diff]
		if ok && val != i {
			return []int{i, val}
		}
	}
	return []int{}
}

// Standalone function for testing
func TwoSumFunc(nums []int, target int) []int {
	sumMap := make(map[int]int)
	for i, num := range nums {
		sumMap[num] = i
	}

	for i, num := range nums {
		diff := target - num
		if j, exists := sumMap[diff]; exists && j != i {
			return []int{i, j}
		}
	}
	return []int{}
}

func ThreeSum(nums []int) [][]int {
	slices.Sort(nums)
	var result [][]int

	for i := 0; i < len(nums); i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		l := i + 1
		r := len(nums) - 1
		for l < r {
			sum := nums[i] + nums[l] + nums[r]
			if sum == 0 {
				result = append(result, []int{nums[i], nums[l], nums[r]})
				l++
				r--
				for l < r && nums[l] == nums[l+1] {
					l++
				}
				for l < r && nums[r] == nums[r-1] {
					r--
				}
			} else if sum < 0 {
				l++
			} else {
				r--
			}
		}
	}
	return result
}

func TwoSumLessThanK(nums []int, k int) int {
	slices.Sort(nums)
	maxSum := 0
	l := 0
	r := len(nums) - 1
	for l < r {
		sum := nums[l] + nums[r]
		if sum < k {
			maxSum = max(maxSum, sum)
			l++
		} else {
			r--
		}
	}
	return maxSum
}

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}


func TwoSumBST(root *TreeNode, target int) bool {
	set := make(map[int]bool)
	queue := []*TreeNode{}
	queue = append(queue, root)
	for len(queue) != 0 {
		curr := queue[0]
		queue = queue[1:]
		if  _, ok := set[target - curr.Val]; ok {
			return true
		}
		set[curr.Val] = true
		if curr.Left != nil {
			queue = append(queue, curr.Left)
		}
		if curr.Right != nil {
			queue = append(queue, curr.Right)
		}
	}
	return false
}
