package Stack

type Stack struct {
	items []int
}

func (s *Stack) Push(val int) {
	s.items = append(s.items, val)
}

func (s *Stack) Pop() int {
	if len(s.items) == 0 {
		return -1
	}
	lastItem := s.items[len(s.items)-1]
	s.items = s.items[:len(s.items)-1]
	return lastItem
}

func (s *Stack) Peek() (int, bool) {
	if len(s.items) == 0 {
		return -1, false
	}
	return s.items[len(s.items)-1], true
}
