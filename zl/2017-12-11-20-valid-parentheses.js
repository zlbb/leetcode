/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  let stack = []
  for(let i of s){
      if(i == '(' || i == '[' || i == '{'){
          stack.push(i)
      } else {
          let t = stack.pop()
          if(i == ')' && t != '(') return false
          if(i == ']' && t != '[') return false
          if(i == '}' && t != '{') return false
          
      }
      
  }
  return stack.length == 0
};