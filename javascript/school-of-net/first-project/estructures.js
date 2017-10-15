// // ########## OBJECT ########## //
// // var prop1 = prompt('Model?')
// // var prop2 = prompt('Name?')
// // var prop3 = prompt('Color?')
// //
// // // Option 1
// // // var obj = {
// // //     model: prop1,
// // //     name : prop2,
// // //     color: prop3
// // // };
// //
// // var obj = {};
// //
// // // Option 2
// //
// // // obj.model = prop1;
// // // obj.name  = prop2;
// // // obj.color = prop3;
// //
// // // Option 3
// // obj["model"] = prop1
// // obj["name"]  = prop2
// // obj["color"] = prop3
// //
// // console.log(JSON.stringify(obj));
// // console.log(obj.toString());
//
// // ########## ARRAY ########## //
// var arr1 = new Array(1,2,3);
//
// function printArr(arr) {
//     console.log('\n--- Printing array ---');
//     arr.forEach(function(value, key) {
//         console.log(arr[key]);
//     });
// }
//
// var arr = [1,2,3];
// arr.push(4);
//
// printArr(arr);
//
// arr.pop(); // remove the last one
//
// printArr(arr);
//
// arr.unshift(10); // insert in first position
//
// printArr(arr);
//
// arr.shift();
//
// printArr(arr);
//
// arr.splice(arr.indexOf(2),1); // The func indexOf() returns the index of array element.
//                               // The func splice() remove Ns Array elements
//
// printArr(arr);
//
// var arr2 = [8,5,12];
//
// arr.concat(arr2);
//
// printArr(arr);
//
// printArr(arr.concat(arr2));
