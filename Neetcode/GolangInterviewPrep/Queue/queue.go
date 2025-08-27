package Queue

type Queue struct {
	items []int
}

func New() *Queue {
	return &Queue{
		items: []int{},
	}
}

func (q *Queue) Enqueue(val int) {
	q.items = append(q.items, val)
}

func (q *Queue) Dequeue() (int, bool) {
	if len(q.items) == 0 {
		return -1, false
	}
	firstItem := q.items[0]
	q.items = q.items[1:]
	return firstItem, true
}

func (q *Queue) Peek() (int, bool) {
	if len(q.items) == 0 {
		return -1, false
	}
	return q.items[0], true
}
