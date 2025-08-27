package main

import (
	"fmt"
	"golanginterviewprep/Queue"
	"golanginterviewprep/Stack"
	"golanginterviewprep/TwoSum"
	"reflect"
)

func main() {
	fmt.Println("Hello, World!")

	a := 10.000000000001
	b := 21
	c := "hello"
	d := "'10.21'"

	fmt.Println(reflect.TypeOf(a))
	fmt.Println(reflect.TypeOf(b))
	fmt.Println(reflect.TypeOf(c))
	fmt.Println(reflect.TypeOf(d))

	fmt.Println(a)
	fmt.Println(b)
	fmt.Println(c)
	fmt.Println(d)

	fmt.Println()

	var myStack Stack.Stack
	myStack.Push(10)
	myStack.Push(20)
	val, _ := myStack.Peek()
	fmt.Println("Top:", val)

	myQueue := Queue.New()
	myQueue.Enqueue(5)
	myQueue.Enqueue(15)
	queueVal, _ := myQueue.Peek()
	fmt.Println("Queue Front:", queueVal)

	myTwoSum := TwoSum.New()
	myTwoSum.Add(1, 2, 3, 4, 5)
	fmt.Println(myTwoSum.Find(8))
	fmt.Println(myTwoSum.Find(10))
}
