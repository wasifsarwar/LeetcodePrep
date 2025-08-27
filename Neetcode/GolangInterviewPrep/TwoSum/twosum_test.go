package TwoSum

import (
	"reflect"
	"testing"
)

func TestTwoSum(t *testing.T) {
	tests := []struct {
		nums   []int
		target int
		want   []int
	}{
		{[]int{2, 7, 11, 15}, 9, []int{0, 1}},
		{[]int{3, 2, 4}, 6, []int{1, 2}},
		{[]int{3, 3}, 6, []int{0, 1}},
	}

	for _, test := range tests {
		got := TwoSumFunc(test.nums, test.target)
		if !reflect.DeepEqual(got, test.want) {
			t.Errorf("TwoSum(%v, %d) = %v, want %v", test.nums, test.target, got, test.want)
		}
	}
}

func TestThreeSum(t *testing.T) {
	tests := []struct {
		nums   []int
		target int
		want   [][]int
	}{
		{[]int{-1, 0, 1, 2, -1, -4}, 0, [][]int{{-1, -1, 2}, {-1, 0, 1}}},
	}

	for _, test := range tests {
		got := ThreeSum(test.nums)
		if !reflect.DeepEqual(got, test.want) {
			t.Errorf("ThreeSum(%v, %d) = %v, want %v", test.nums, test.target, got, test.want)
		}
	}
}

func TestTwoSumLessThanK(t *testing.T) {
	tests := []struct {
		nums []int
		k    int
		want int
	}{
		{[]int{34, 23, 1, 24, 75, 33, 54, 8}, 60, 58},
		{[]int{1, 2, 3, 4, 5}, 10, 9},
		{[]int{1, 2, 3, 4, 5}, 1, 0},
	}

	for _, test := range tests {
		got := TwoSumLessThanK(test.nums, test.k)
		if got != test.want {
			t.Errorf("TwoSumLessThanK(%v, %d) = %d, want %d", test.nums, test.k, got, test.want)
		}
	}
}

func TestTwoSumBST(t *testing.T) {
	tests := []struct {
		root *TreeNode
		target int
		want bool
	}{
		{&TreeNode{Val: 5, Left: &TreeNode{Val: 3, Left: &TreeNode{Val: 2}, Right: &TreeNode{Val: 4}}, Right: &TreeNode{Val: 6, Right: &TreeNode{Val: 7}}}, 9, true},
		{&TreeNode{Val: 5, Left: &TreeNode{Val: 3, Left: &TreeNode{Val: 2}, Right: &TreeNode{Val: 4}}, Right: &TreeNode{Val: 6, Right: &TreeNode{Val: 7}}}, 28, false},
	}

	for _, test := range tests {
		got := TwoSumBST(test.root, test.target)
		if got != test.want {
			t.Errorf("TwoSumBST(%v, %d) = %v, want %v", test.root, test.target, got, test.want)
		}
	}
}