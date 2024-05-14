const btn = document.querySelector(".btn");
const list = document.querySelector("#dropdown");
const input = document.querySelector(".myDropdown");

btn.addEventListener("click", (e)=>{
e.preventDefault();
    const option = document.createElement("option");
    option.text = input.value;
    dropdown.appendChild(option);
    input.value = "";
})