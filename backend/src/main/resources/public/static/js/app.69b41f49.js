(function(e){function t(t){for(var n,s,i=t[0],u=t[1],c=t[2],l=0,d=[];l<i.length;l++)s=i[l],Object.prototype.hasOwnProperty.call(o,s)&&o[s]&&d.push(o[s][0]),o[s]=0;for(n in u)Object.prototype.hasOwnProperty.call(u,n)&&(e[n]=u[n]);f&&f(t);while(d.length)d.shift()();return a.push.apply(a,c||[]),r()}function r(){for(var e,t=0;t<a.length;t++){for(var r=a[t],n=!0,s=1;s<r.length;s++){var u=r[s];0!==o[u]&&(n=!1)}n&&(a.splice(t--,1),e=i(i.s=r[0]))}return e}var n={},o={app:0},a=[];function s(e){return i.p+"static/js/"+({about:"about"}[e]||e)+"."+{about:"5b8deb59"}[e]+".js"}function i(t){if(n[t])return n[t].exports;var r=n[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,i),r.l=!0,r.exports}i.e=function(e){var t=[],r=o[e];if(0!==r)if(r)t.push(r[2]);else{var n=new Promise((function(t,n){r=o[e]=[t,n]}));t.push(r[2]=n);var a,u=document.createElement("script");u.charset="utf-8",u.timeout=120,i.nc&&u.setAttribute("nonce",i.nc),u.src=s(e);var c=new Error;a=function(t){u.onerror=u.onload=null,clearTimeout(l);var r=o[e];if(0!==r){if(r){var n=t&&("load"===t.type?"missing":t.type),a=t&&t.target&&t.target.src;c.message="Loading chunk "+e+" failed.\n("+n+": "+a+")",c.name="ChunkLoadError",c.type=n,c.request=a,r[1](c)}o[e]=void 0}};var l=setTimeout((function(){a({type:"timeout",target:u})}),12e4);u.onerror=u.onload=a,document.head.appendChild(u)}return Promise.all(t)},i.m=e,i.c=n,i.d=function(e,t,r){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(i.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)i.d(r,n,function(t){return e[t]}.bind(null,n));return r},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/",i.oe=function(e){throw console.error(e),e};var u=window["webpackJsonp"]=window["webpackJsonp"]||[],c=u.push.bind(u);u.push=t,u=u.slice();for(var l=0;l<u.length;l++)t(u[l]);var f=c;a.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("56d7")},"034f":function(e,t,r){"use strict";r("85ec")},"31f2":function(e,t,r){"use strict";r("ebce")},"56d7":function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var n=r("2b0e"),o=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("div",{attrs:{id:"nav"}},[r("router-link",{attrs:{to:"/"}},[e._v("Home")]),e._v(" | "),r("router-link",{attrs:{to:"/about"}},[e._v("About")])],1),r("router-view")],1)},a=[],s=(r("034f"),r("2877")),i={},u=Object(s["a"])(i,o,a,!1,null,null,null),c=u.exports,l=(r("d3b7"),r("3ca3"),r("ddb0"),r("8c4f")),f=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"home"},[n("img",{attrs:{alt:"Vue logo",src:r("cf05")}}),n("HelloWorld"),n("Invite")],1)},d=[],p=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"user"},[r("h1",[e._v(e._s(e.msg))]),r("h1",[e._v("Create User")]),r("h3",[e._v("Just some database interaction...test 1 deploy")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.firstName,expression:"user.firstName"}],attrs:{type:"text",placeholder:"first name"},domProps:{value:e.user.firstName},on:{input:function(t){t.target.composing||e.$set(e.user,"firstName",t.target.value)}}}),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.lastName,expression:"user.lastName"}],attrs:{type:"text",placeholder:"last name"},domProps:{value:e.user.lastName},on:{input:function(t){t.target.composing||e.$set(e.user,"lastName",t.target.value)}}}),r("button",{on:{click:function(t){return e.createNewUser()}}},[e._v("Create User")]),e.showResponse?r("div",[r("h6",[e._v("User created with Id: "+e._s(e.user.id))])]):e._e(),e.showResponse?r("button",{on:{click:function(t){return e.retrieveUser()}}},[e._v("Retrieve user "+e._s(e.user.id)+" data from database")]):e._e(),e.showRetrievedUser?r("h4",[e._v("Retrieved User "+e._s(e.retrievedUser.firstName)+" "+e._s(e.retrievedUser.lastName))]):e._e()])},m=[],v=r("bc3a"),h=r.n(v),b={name:"HelloWorld",data:function(){return{errors:[],showResponse:!1,showRetrievedUser:!1,user:{id:0,firstName:"",lastName:""},retrievedUser:{id:0,firstName:"",lastName:""}}},methods:{createNewUser:function(){var e=this;Object(v["post"])("/api/user/",{firstName:this.user.firstName,lastName:this.user.lastName}).then((function(t){e.user.id=t.data,console.log("Created new User with Id "+t.data),e.showResponse=!0})).catch((function(t){e.errors=t.response.data.message}))}}},_=b,g=(r("31f2"),Object(s["a"])(_,p,m,!1,null,null,null)),w=g.exports,N=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},y=[function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"user"},[r("h1",[e._v("Invite")]),r("h3",[e._v("invite")])])}],j={name:"Invite",data:function(){return{errors:[],showResponse:!1,showRetrievedUser:!1,user:{id:0,firstName:"",lastName:""},retrievedUser:{id:0,firstName:"",lastName:""}}},methods:{}},O=j,x=(r("e515"),Object(s["a"])(O,N,y,!1,null,null,null)),U=x.exports,P={name:"Home",components:{Invite:U,HelloWorld:w}},k=P,R=Object(s["a"])(k,f,d,!1,null,null,null),C=R.exports;n["a"].use(l["a"]);var E=[{path:"/",name:"Home",component:C},{path:"/about",name:"About",component:function(){return r.e("about").then(r.bind(null,"f820"))}}],$=new l["a"]({mode:"history",base:"/",routes:E}),I=$,H=r("2106"),S=r.n(H);n["a"].use(S.a,h.a),n["a"].config.productionTip=!1,new n["a"]({router:I,render:function(e){return e(c)}}).$mount("#app");var T=localStorage.getItem("user-token");T&&(h.a.defaults.headers.common["Authorization"]="Bearer "+T)},"85ec":function(e,t,r){},"9d3a":function(e,t,r){},cf05:function(e,t,r){e.exports=r.p+"static/img/logo.82b9c7a5.png"},e515:function(e,t,r){"use strict";r("9d3a")},ebce:function(e,t,r){}});
//# sourceMappingURL=app.69b41f49.js.map