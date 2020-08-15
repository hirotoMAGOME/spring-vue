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

      // var params = { domainCdList };

      // //axiosのconfigを変えて、配列の形式を変更する
      // //OK http://localhost:8080/api/com/cls-type?domainCdList=budget_category_type&domainCdList=user_type
      // //NG http://localhost:8080/api/com/cls-type?domainCdList[]=budget_category_type&domainCdList[]=user_type
      // let myAxios = axios.create({
      //     paramsSerializer: params => Qs.stringify(params, { arrayFormat: 'repeat' })
      // })

      // //GETの実行
      // myAxios
      //     .get(API_PATH_COM_01, { params })
      //     .then(function (res) {
      //         console.log("aaa");
      //         return res.data;
      //     })
      //     .catch(function () {
      //         return [];
      //     });
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
    }
  }
}
