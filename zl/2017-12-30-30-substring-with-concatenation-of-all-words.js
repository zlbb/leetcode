/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
var findSubstring = function (s, words) {
    if (words.length == 0) return []
    var res = []
    for (var i = 0; i < s.length; i++) {
        if (substringMatch(s, i, words)) {
            res.push(i)
        }
    }
    return res
};

var substringMatch = function (s, idx, words) {

    if (words.length == 0) return true
    //if(s.length - idx < words.map(i=>i.length).reduce((i,j)=>i+j)) return false
    for (let i in words) {
        if (s.slice(idx).indexOf(words[i]) == 0) {
            return substringMatch(s, idx + words[i].length, words.filter((item, idx) => idx != i))
        }
    }
    return false
}

// v2 fix length
var findSubstring = function (s, words) {
    let res = []
    if (words.length == 0) return res
    const len = words[0].length
    let cntMap = {}
    words.forEach(i => {
        cntMap[i] = cntMap[i] ? cntMap[i] + 1 : 1
    });
    for (let i = 0; i < s.length; i++) {
        let map = Object.assign({}, cntMap)
        let j = 0
        for (; j < words.length; j++) {
            let substr = s.slice(i + j * len, i + (j + 1) * len)
            if (map[substr] > 0) {
                map[substr]--
            } else {
                break
            }
        }
        if (j == words.length)
            res.push(i)
    }
    return res
};