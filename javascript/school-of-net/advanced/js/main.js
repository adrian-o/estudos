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

    document.getElementById('spnTotal').innerHTML = formatValue(total);
}

function setList() {
    var table = '<thead><tr><td>Description</td><td>Amount</td><td>Value</td><td>Action</td></tr></thead><tbody>';
    for (var key in products) {
        var product = products[key];
        var trT = '<tr><td>'+formatDesc(product.desc)+'</td>'+
                       '<td>'+formatAmount(product.amount)+'</td>'+
                       '<td>'+formatValue(product.value)+'</td>'+
                       '<td><button class="btn btn-default" onclick="setUpdate('+key+')">Edit</button> |'+
                       '    <button class="btn btn-default" onclick="deleteProduct('+key+')">Delete</button></td>'+
                  '</tr>';
        table += trT;
    }
    table += '</tbody>';
    document.getElementById('listTable').innerHTML = table;
    getTotal(products);
    saveListStorage();
}

function formatDesc(desc) {
    var str = desc.toLowerCase();
    str = str.charAt(0).toUpperCase() + str.slice(1);
    return str;
}

function formatAmount(amount) {
    return parseInt(amount);
}

function formatValue(value) {
    return 'R$ ' + value.toFixed(2).toString().replace('.',',');
}

function addProduct() {
    if (!validation()) {
        return;
    }

    products.unshift(
        {"desc": document.getElementById("desc").value,
         "amount": document.getElementById("amount").value,
         "value": parseFloat(document.getElementById("value").value)});
    resetForm();
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
    document.getElementById('spnErrors').style.display = "none";
    document.getElementById("btnAdd").style.display = 'inline-block';
}

function updateProduct() {
    if (!validation()) {
        return;
    }

    var prod = products[document.getElementById('keyProd').value];
    prod.desc = document.getElementById('desc').value;
    prod.amount = document.getElementById('amount').value;
    prod.value = parseFloat(document.getElementById('value').value);
    resetForm();
    setList();
}

function deleteProduct(key) {
    if (confirm('Do yoy want to delete this product?')) {
        if (key === 0) {
            products.shift();
        } else if (key === products.length - 1) {
            products.pop();
        } else {
            var listIni = products.slice(0,key);
            var listEnd = products.slice(key+1);
            products = listIni.concat(listEnd);
        }

        setList();
    }
}

function validation() {
    var desc   = document.getElementById('desc').value;
    var amount = document.getElementById('amount').value
    var value  = document.getElementById('value').value

    document.getElementById('spnErrors').style.display = "none";

    var errors = "";

    if (desc === "") {
        errors += '<p>Fill out description</p>';
    }

    if (amount === "") {
        errors += '<p>Fill out amount</p>';
    } else if (amount != parseInt(amount)) {
        errors += '<p>Amount must be a number</p>';
    }

    if (value === "") {
        errors += '<p>Fill out value</p>';
    } else if (value != parseFloat(value)) {
        errors += '<p>Value must be a number</p>';
    }

    if (errors != "") {
        document.getElementById('spnErrors').style.display = "block";
        document.getElementById('spnErrors').style.backgroundColor = "#ec9893";
        document.getElementById('spnErrors').style.padding = "10px";
        document.getElementById('spnErrors').style.margin = "8px";
        document.getElementById('spnErrors').style.borderRadius = "10px";
        document.getElementById('spnErrors').innerHTML = "<h3>Error: </h3>" + errors;
        return 0;
    } else {
        return 1;
    }
}

function deleAllProducts() {
    if (confirm('Do you want delete all the list?')) {
        products = [];
        setList();
    }
}

function saveListStorage() {
    var jsonProducts = JSON.stringify(products);
    localStorage.setItem("products", jsonProducts);
}

function initListStorage() {
    var testProds = localStorage.getItem("products");
    if(testProds) {
        products = JSON.parse(testProds);
    }
    setList();
}

initListStorage();
