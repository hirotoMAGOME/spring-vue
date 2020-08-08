import axios from "axios"
// import Qs from "qs";
const API_PATH_COM_01 = "http://localhost:8080/api/com/cls-type"

export default {
  methods: {
    getClsType: function(domainCdList, toSnakeFromCamelFlg) {
      if (toSnakeFromCamelFlg) {
        this.transformationToSnakeFromCamel({ aaa: "aaa" })
      }

      var returnObj = {}
      if (Array.isArray(domainCdList)) {
        domainCdList.forEach(function(domainCd) {
          var params = { domainCdList: domainCd }
          axios
            .get(API_PATH_COM_01, { params })
            .then(function(res) {
              returnObj[domainCd] = res.data.clstypes
            })
            .catch(function() {})
        })

        return returnObj
      } else {
        var params = { domainCdList: domainCdList }
        axios
          .get(API_PATH_COM_01, { params })
          .then(function(res) {
            returnObj[domainCdList] = res.data.clstypes
          })
          .catch(function() {})

        return returnObj
      }

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
    transformationToCamelFromSnake: function(Snake) {
      if (this.isObject(Snake)) {
        console.log("aaa")
      } else if (this.isArray(Snake)) {
        console.log("bbb")
      } else {
        console.log("ccc")
      }
    },
    transformationToCamelTextFromSnakeText: function(SnakeText) {
      return SnakeText.replace(/_./g, function(s) {
        return s.charAt(1).toUpperCase()
      })
    },
    isArray: function(item) {
      console.log("isArray起動")
      return Object.prototype.toString.call(item) === "[object Array]"
    },
    isObject: function(item) {
      console.log("isObject起動")
      return typeof item === "object" && item !== null && !this.isArray(item)
    }
  }
}