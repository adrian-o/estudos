/// <reference path="src/Product.ts" />

module App {
    var p = new Product("Book 1", "My book 1", 10.0);
    document.getElementById("app").innerHTML = `
        <div>
            <ul>
                <li>${p.name} - ${p.description} - $${p.value}</li>
            </ul>
        </div>
    `;
}
