package BinarySearch

import (
	"reflect"
	"testing"
)

func TestBinarySearch(t *testing.T) {
	tests := []struct {
		nums   []int
		target int
		want   int
	}{
		{[]int{2, 7, 11, 15}, 11, 2},
		{[]int{2, 4, 9}, 4, 1},
		{[]int{3, 3}, 6, -1},
		{[]int{1, 3, 5, 6}, 10, -1},
	}

	for _, test := range tests {
		got := BinarySearch(test.nums, test.target)
		if !reflect.DeepEqual(got, test.want) {
			t.Errorf("BinarySearch(%v, %d) = %v, want %v", test.nums, test.target, got, test.want)
		}
	}
}
