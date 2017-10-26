/// <reference path="IProduct.ts" />
var ImplInterface;
(function (ImplInterface) {
    var Producct = /** @class */ (function () {
        function Producct(name, description, value) {
            this.name = name;
            this.description = description;
            this.value = value;
        }
        ;
        return Producct;
    }());
    ImplInterface.Producct = Producct;
})(ImplInterface || (ImplInterface = {}));
