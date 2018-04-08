var isValidSerialization = function(preorder) {
  var items = preorder.split(',')
  var diff = 1
  for(var i of items){
    if(--diff < 0 ) return false
    if(i != '#') diff +=2
  }
  return diff ==  0
};

console.log(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"))