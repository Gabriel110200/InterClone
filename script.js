$(document).ready(() => {



    window.addEventListener('scroll', () => {


        let windowPosition = window.scrollY > 1;

        $(".navbar").toggleClass("scrolledNav", windowPosition);


    })

    $('#cpfInput').mask('000.000.000-00', { reverse: true });


})