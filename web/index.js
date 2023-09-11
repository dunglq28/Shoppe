/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const modal = document.querySelector(".modal")
const register = document.querySelector(".header__navbar-item--register")
const login = document.querySelector(".header__navbar-item--login")
const formRegister = document.querySelector(".auth-form--Register")
const formLogin = document.querySelector(".auth-form--Login")
const switchForm = document.querySelectorAll(".auth-form__switch-bth")
const modal__overlay = document.querySelector(".modal__overlay")


function showModalRegister() {
    modal.classList.remove("modal--active")
    formLogin.classList.remove("auth-form--Login-active")
    modal.classList.add("modal--active")
    formRegister.classList.add("auth-form--Register-active")
}
function showModalLogin() {
    modal.classList.remove("modal--active")
    formRegister.classList.remove("auth-form--Register-active")
    modal.classList.add("modal--active")
    formLogin.classList.add("auth-form--Login-active")
}
function changeModal(inputType) {
    if(inputType == "Đăng nhập") {
        showModalLogin();
    } else {
        showModalRegister();
    }
}
function closeModal() {
    modal.classList.remove("modal--active")
}


register.addEventListener("click", showModalRegister)
login.addEventListener("click", showModalLogin)
for (const input of switchForm) {
    input.onclick = () => changeModal(input.innerHTML);
}
modal__overlay.addEventListener("click", closeModal)


