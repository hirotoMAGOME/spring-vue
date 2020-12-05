<template>
  <el-header
    id="app-shared-header"
    style="background-color: rgb(238, 241, 246)"
  >
    <el-menu
      :default-active="activeIndex2"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item index="1">ホームへ</el-menu-item>
      <el-submenu index="2">
        <template slot="title">資産管理</template>
        <el-menu-item index="2-1">
          <a href="/cost-performance">サマリー</a>
        </el-menu-item>
        <el-menu-item index="2-2">
          <a href="/cost-performance">予実登録更新</a>
        </el-menu-item>
        <el-menu-item index="2-3">
          <a href="/asset-master">資産マスタ登録更新</a>
        </el-menu-item>
        <el-submenu index="2-4">
          <template slot="title">item four</template>
          <el-menu-item index="2-4-1">item one</el-menu-item>
          <el-menu-item index="2-4-2">item two</el-menu-item>
          <el-menu-item index="2-4-3">item three</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index="3" disabled>Info</el-menu-item>
      <el-submenu index="4">
        <template slot="title">開発用</template>
        <el-menu-item index="4-1">
          <a href="/develop-tool/ui-parts">画面パーツ</a>
        </el-menu-item>
        <el-menu-item index="4-2">
          <a href="/develop-tool/auto-test">自動テスト</a>
        </el-menu-item>
      </el-submenu>
      <el-menu-item index="5">
        <a
          href="https://www.notion.so/Getting-Started-20047802b46042618e1e50c75c42bc0c"
          target="_blank"
          >notion</a
        >
      </el-menu-item>
      <el-menu-item index="6">
        <a href="/book-mark">リンク集</a>
      </el-menu-item>
    </el-menu>
  </el-header>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1"
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>
