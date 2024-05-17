enum Size{
Small = "small",
Large = "large",
Medium = "medium"
}
enum Color{
    Red = "red",
Gold = "gold",
Emerald = "emerald"
}

interface Product{
    title: string,
    desc : string,
    sizes: Size[] | Size,
    price : number,
    color: Color[] | Color
}

let product1 : Product = {
    title: "Watch",
    desc: "Patek Phillipe",
    sizes: [Size.Large, Size.Medium],
    price: 6000000.00,
    color: [Color.Emerald, Color.Gold]
}
let product2 : Product = {
    title: "Car",
    desc: "BMW",
    sizes: Size.Large,
    price: 6000000.00,
    color: [Color.Emerald, Color.Gold]
}
let products = [product1,product2]
function getProduct(index) : Product {
    return products[index];
}

console.log(getProduct(0));