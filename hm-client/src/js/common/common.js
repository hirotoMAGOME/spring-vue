import axios from "axios"
// import Qs from "qs";
const API_PATH_COM_01 = "http://localhost:8080/api/com/cls-type"

export default {
  methods: {
    getClsType: function(domainCdList, toSnakeFromCamelFlg) {
      var that = this
      return new Promise(function(resolve, reject) {
        var returnObj = {}
        if (Array.isArray(domainCdList)) {
          domainCdList.forEach(function(domainCd) {
            var params = { domainCdList: domainCd }
            axios
              .get(API_PATH_COM_01, { params })
              .then(function(res) {
                returnObj[domainCd] = res.data.clstypes
                return returnObj
              })
              .catch(function() {})
          })
        } else {
          var params = { domainCdList: domainCdList }
          axios
            .get(API_PATH_COM_01, { params })
            .then(function(res) {
              var returnKey = ""
              if (toSnakeFromCamelFlg) {
                returnKey = that.transformationToCamelTextFromSnakeText(
                  domainCdList
                )
              } else {
                returnKey = domainCdList
              }
              returnObj[returnKey] = res.data.clstypes

              // return returnObj
              resolve(returnObj)
            })
            .catch(function() {
              reject("error common.js reject")
            })
        }
      })
    },
    isArray: function(item) {
      return Object.prototype.toString.call(item) === "[object Array]"
    },
    isObject: function(item) {
      return typeof item === "object" && item !== null && !this.isArray(item)
    },
    transformationToCamelTextFromSnakeText: function(SnakeText) {
      return SnakeText.replace(/_./g, function(s) {
        return s.charAt(1).toUpperCase()
      })
    },
    objectArraySort: function(key, order = "asc") {
      return function(a, b) {
        // if (!a.hasOwnProperty(key) || !b.hasOwnProperty(key)) {
        if (
          !Object.prototype.hasOwnProperty.call(a, key) ||
          !Object.prototype.hasOwnProperty.call(b, key)
        ) {
          console.log("NG")
          console.log(key)
          // property doesn't exist on either object
          return 0
        }

        const varA = typeof a[key] === "string" ? a[key].toUpperCase() : a[key]
        const varB = typeof b[key] === "string" ? b[key].toUpperCase() : b[key]

        let comparison = 0
        if (varA > varB) {
          comparison = 1
        } else if (varA < varB) {
          comparison = -1
        }
        return order == "desc" ? comparison * -1 : comparison
      }
    },
    ////////////////////////
    // 表示系
    ////////////////////////
    deleteSsfromDatetime: function (input) {
      // yyyy/MM/dd HH:mm:ss → yyyy/MM/dd HH:mm
      let output = input.slice(0,-3)
      return output
    }
  }
}
