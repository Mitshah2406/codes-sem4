var Size;
(function (Size) {
    Size["Small"] = "small";
    Size["Large"] = "large";
    Size["Medium"] = "medium";
})(Size || (Size = {}));
var product = {
    title: "Watch",
    desc: "Patek Phillipe",
    sizes: [Size.Large, Size.Medium],
    price: 6000000.00,
    color: ["Emerald", "Gold"]
};
function getProduct() {
    return product;
}
console.log(getProduct());
