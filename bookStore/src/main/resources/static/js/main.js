const btn1 = document.querySelector("#btn1")
const btn2 = document.querySelector("#btn2")
const btn3 = document.querySelector("#btn3")
const content1 = document.querySelector("#tab1")
const content2 = document.querySelector("#tab2")
const content3 = document.querySelector("#tab3")

btn1.addEventListener("click", () => {
    btn1.style.backgroundColor = "#35b8be"
    btn2.style.backgroundColor = "#ffffff"
    btn3.style.backgroundColor = "#ffffff"
    content1.style.display="block"
    content2.style.display = "none"
    content3.style.display = "none"
})

btn2.addEventListener("click", () => {
    btn2.style.backgroundColor = "#35b8be"
    btn1.style.backgroundColor = "#ffffff"
    btn3.style.backgroundColor = "#ffffff"
    content2.style.display="block"
    content1.style.display="none"
    content3.style.display="none"
})

btn3.addEventListener("click", () => {
    btn3.style.backgroundColor = "#35b8be"
    btn1.style.backgroundColor = "#ffffff"
    btn2.style.backgroundColor = "#ffffff"
    content3.style.display="block"
    content1.style.display="none"
    content2.style.display="none"
})

