// To OK Button
function validateNumber() {
    var num_val = document.getElementById('num_val').value;
    if (isNaN(num_val) || (num_val>=1 && num_val<=10)) {
        alert("It's not a valid number...");
    }
}

// To Click me Button

var click_me = document.getElementById("click_me");

click_me.addEventListener('click', function(){
    alert('You clicked me...');
});

// Over in DIV element
function over(obj) {
    //console.log("My text in H2");
    obj.style.background = '#fff002';
}

function out(obj) {
    obj.style.background = '#000000';
}

// Input tests
var input_number = document.getElementsByClassName("val_input_number");
var generate_btn = document.getElementById('generate_btn');

generate_btn.addEventListener('click', function(){
    var input_val = input_number[0].value;

    for(var i = 0; i < input_val; i++) {
        var inpt = document.createElement('input');
        inpt.id = 'input_' + i;
        var body_tag = document.getElementsByTagName('body');

        body_tag[0].appendChild(inpt);
    }
});

var body_tag1 = document.getElementsByTagName('body');
var select_inpt = document.createElement('select');

select_inpt.id = 'select1';

for (var i=0; i<10; i++) {
    var option = document.createElement('option');
    option.id = 'opt_' + i;
    option.value = i;
    option.innerHTML = i;

    select_inpt.appendChild(option);
}

body_tag1[0].appendChild(select_inpt);

// CSS manipulate
var title = document.getElementById("h1_main");
title.style.color = '#fff000';
