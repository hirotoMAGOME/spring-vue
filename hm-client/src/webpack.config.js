// const path = require('path');

// module.exports = {
//   entry: './src/index.js',
//   output: {
//     filename: 'main.js',
//     path: path.resolve(__dirname, 'dist')
//   },
//   module: {
//       rules: [
//         {
//           enforce: 'pre',
//           test: /\.js$/,
//           exclude: /node_modules/,
//           loader: 'eslint-loader'
//         },
//         {
//           test: /\.js$/,
//           loader: 'babel-loader',
//           exclude: /node_modules/
//         },
//         {
//           test: /\.css/,
//           use: [
//             "style-loader",
//             {
//               loader: "css-loader",
//               options: { url: false }
//             }
//           ]
//         }
//     ]
//   }
// };



const { VueLoaderPlugin } = require('vue-loader');

module.exports = {
  // モード値を production に設定すると最適化された状態で、
  // development に設定するとソースマップ有効でJSファイルが出力される
  mode: 'production',

  module: {
    rules: [
      {
        test: /\.css$/,
        use: ["vue-style-loader", "css-loader"]
      },

      {
        test: /\.vue$/,
        loader: "vue-loader"
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        // Babel のオプションを指定する
        options: {
          presets: [
            // プリセットを指定することで、ES2020 を ES5 に変換
            '@babel/preset-env',
          ]
        }
      },
    ]
  },
  // import 文で .ts ファイルを解決するため
  resolve: {
    // Webpackで利用するときの設定
    alias: {
      'vue$': 'vue/dist/vue.esm.js'
    },
    extensions: ['*', '.js', '.vue', '.json']
  },
  plugins: [
    // Vueを読み込めるようにするため
    new VueLoaderPlugin(),
  ],
};