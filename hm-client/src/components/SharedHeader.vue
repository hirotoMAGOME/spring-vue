<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <router-link class="text-white px-3" to="/">home</router-link>
          </li>
          <li class="nav-item">
            <router-link class="text-white px-3" to="/test1">test</router-link>
          </li>
          <li class="nav-item">
            <router-link class="text-white px-3" to="/asset">資産管理</router-link>
          </li>
          <li class="nav-item">
            <router-link class="text-white px-3" to="/currency">currency</router-link>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>