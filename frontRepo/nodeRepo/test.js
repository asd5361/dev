/*객체 생성하기 */
// const x = {
//     name : '심원용',
//     age : 20

// };
/* 생성자 함수 */
// function Person(x,y) {
//     this.name = x;
//     this.age = y;

// }

// Person.prototype.hello = function(){
//     console.log("프로토 함수(부모)");
// };

/* 클래스 */
class Person{
    constructor(){
        this.name = "심원용";
        this.age = 20;
    }
    hello(){
        console.log("hello~ (생성자 밖에 있는 함수)");
    }
}
class Programmer extends Person{
    constructor(x,y,z){
        super(x,y);
        this.lang = z;
    }
    coding(){
        console.log("코딩코딩");
    }
}
const p2 = new Programmer('심원용',20,10);
console.log(p2);
p2.hello();
p2.coding();

const p1 = new Person('~~',20);
console.log(p1);
p1.hello();


Person.prototype.hello();