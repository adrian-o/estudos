var products = [
    {"desc":"rice", "amount":1 , "value":5.10 },
    {"desc":"beer", "amount":10, "value":2.20 },
    {"desc":"meat", "amount":1 , "value":15.00}
];

function getTotal(products) {
    var total = 0;
    for (var key in products) {
        var product = products[key];
        total += (product.value * product.amount);
    }
    return total;
}

function setList() {
    var table = '<thead><tr><td>Description</td><td>Amount</td><td>Value</td><td>Action</td></tr></thead><tbody>';
    for (var key in products) {
        var product = products[key];
        var trT = '<tr><td>'+formatDesc(product.desc)+'</td>'+
                       '<td>'+product.amount+'</td>'+
                       '<td>'+formatValue(product.value)+'</td>'+
                       '<td><button class="btn btn-default" onclick="setUpdate('+key+')">Edit</button> |'+
                       '    <button class="btn btn-default" onclick="deleteProduct('+key+')">Delete</button></td>'+
                  '</tr>';
        table += trT;
    }
    table += '</tbody>';
    document.getElementById('listTable').innerHTML = table;
    console.log(getTotal(products));
}

function formatDesc(desc) {
    var str = desc.toLowerCase();
    str = str.charAt(0).toUpperCase() + str.slice(1);
    return str;
}

function formatValue(value) {
    return 'R$ ' + value.toFixed(2).toString().replace('.',',');
}

function addProduct() {
    products.unshift(
        {"desc": document.getElementById("desc").value,
         "amount": document.getElementById("amount").value,
         "value": parseFloat(document.getElementById("value").value)});

    setList();
}

function setUpdate(key) {
    var prod = products[key];
    document.getElementById("keyProd").value = key;
    document.getElementById("desc").value = prod.desc;
    document.getElementById("amount").value = prod.amount;
    document.getElementById("value").value = prod.value;
    document.getElementById("spnUpdate").style.display = 'inline-block';
    document.getElementById("btnAdd").style.display = 'none';
}

function resetForm() {
    document.getElementById("keyProd").value = '';
    document.getElementById("desc").value = '';
    document.getElementById("amount").value = '';
    document.getElementById("value").value = '';
    document.getElementById("spnUpdate").style.display = 'none';
    document.getElementById("btnAdd").style.display = 'inline-block';
}

function updateProduct() {
    var prod = products[document.getElementById('keyProd').value];
    prod.desc = document.getElementById('desc').value;
    prod.amount = document.getElementById('amount').value;
    prod.value = parseFloat(document.getElementById('value').value);
    resetForm();
    setList();
}

function deleteProduct() {

}

setList();
