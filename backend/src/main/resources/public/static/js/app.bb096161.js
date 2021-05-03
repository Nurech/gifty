(function(e){function t(t){for(var n,s,u=t[0],i=t[1],c=t[2],l=0,f=[];l<u.length;l++)s=u[l],Object.prototype.hasOwnProperty.call(o,s)&&o[s]&&f.push(o[s][0]),o[s]=0;for(n in i)Object.prototype.hasOwnProperty.call(i,n)&&(e[n]=i[n]);d&&d(t);while(f.length)f.shift()();return a.push.apply(a,c||[]),r()}function r(){for(var e,t=0;t<a.length;t++){for(var r=a[t],n=!0,s=1;s<r.length;s++){var i=r[s];0!==o[i]&&(n=!1)}n&&(a.splice(t--,1),e=u(u.s=r[0]))}return e}var n={},o={app:0},a=[];function s(e){return u.p+"static/js/"+({about:"about"}[e]||e)+"."+{about:"0948535d"}[e]+".js"}function u(t){if(n[t])return n[t].exports;var r=n[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,u),r.l=!0,r.exports}u.e=function(e){var t=[],r=o[e];if(0!==r)if(r)t.push(r[2]);else{var n=new Promise((function(t,n){r=o[e]=[t,n]}));t.push(r[2]=n);var a,i=document.createElement("script");i.charset="utf-8",i.timeout=120,u.nc&&i.setAttribute("nonce",u.nc),i.src=s(e);var c=new Error;a=function(t){i.onerror=i.onload=null,clearTimeout(l);var r=o[e];if(0!==r){if(r){var n=t&&("load"===t.type?"missing":t.type),a=t&&t.target&&t.target.src;c.message="Loading chunk "+e+" failed.\n("+n+": "+a+")",c.name="ChunkLoadError",c.type=n,c.request=a,r[1](c)}o[e]=void 0}};var l=setTimeout((function(){a({type:"timeout",target:i})}),12e4);i.onerror=i.onload=a,document.head.appendChild(i)}return Promise.all(t)},u.m=e,u.c=n,u.d=function(e,t,r){u.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},u.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},u.t=function(e,t){if(1&t&&(e=u(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(u.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)u.d(r,n,function(t){return e[t]}.bind(null,n));return r},u.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return u.d(t,"a",t),t},u.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},u.p="/",u.oe=function(e){throw console.error(e),e};var i=window["webpackJsonp"]=window["webpackJsonp"]||[],c=i.push.bind(i);i.push=t,i=i.slice();for(var l=0;l<i.length;l++)t(i[l]);var d=c;a.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("56d7")},"56d7":function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var n=r("2b0e"),o=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("div",{attrs:{id:"nav"}},[r("router-link",{attrs:{to:"/"}},[e._v("Home")]),e._v(" | "),r("router-link",{attrs:{to:"/about"}},[e._v("About")])],1),r("router-view")],1)},a=[],s=(r("5c0b"),r("2877")),u={},i=Object(s["a"])(u,o,a,!1,null,null,null),c=i.exports,l=(r("d3b7"),r("3ca3"),r("ddb0"),r("8c4f")),d=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"home"},[n("img",{attrs:{alt:"Vue logo",src:r("cf05")}}),n("HelloWorld",{attrs:{msg:"Welcome to Your Vue.js App"}})],1)},f=[],p=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"user"},[r("h1",[e._v(e._s(e.msg))]),r("h1",[e._v("Create User")]),r("h3",[e._v("Just some database interaction...")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.firstName,expression:"user.firstName"}],attrs:{type:"text",placeholder:"first name"},domProps:{value:e.user.firstName},on:{input:function(t){t.target.composing||e.$set(e.user,"firstName",t.target.value)}}}),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.lastName,expression:"user.lastName"}],attrs:{type:"text",placeholder:"last name"},domProps:{value:e.user.lastName},on:{input:function(t){t.target.composing||e.$set(e.user,"lastName",t.target.value)}}}),r("button",{on:{click:function(t){return e.createNewUser()}}},[e._v("Create User")]),e.showResponse?r("div",[r("h6",[e._v("User created with Id: "+e._s(e.user.id))])]):e._e(),e.showResponse?r("button",{on:{click:function(t){return e.retrieveUser()}}},[e._v("Retrieve user "+e._s(e.user.id)+" data from database")]):e._e(),e.showRetrievedUser?r("h4",[e._v("Retrieved User "+e._s(e.retrievedUser.firstName)+" "+e._s(e.retrievedUser.lastName))]):e._e()])},m=[],v=r("bc3a"),h=r.n(v),b={name:"HelloWorld",data:function(){return{errors:[],showResponse:!1,showRetrievedUser:!1,user:{id:0,firstName:"",lastName:""},retrievedUser:{id:0,firstName:"",lastName:""}}},methods:{createNewUser:function(){var e=this;Object(v["post"])("/api/user/",{firstName:this.user.firstName,lastName:this.user.lastName}).then((function(t){e.user.id=t.data,console.log("Created new User with Id "+t.data),e.showResponse=!0})).catch((function(t){e.errors=t.response.data.message}))}}},g=b,_=(r("756a"),Object(s["a"])(g,p,m,!1,null,"65060fb0",null)),w=_.exports,y={name:"Home",components:{HelloWorld:w}},N=y,j=Object(s["a"])(N,d,f,!1,null,null,null),O=j.exports;n["a"].use(l["a"]);var x=[{path:"/",name:"Home",component:O},{path:"/about",name:"About",component:function(){return r.e("about").then(r.bind(null,"f820"))}}],U=new l["a"]({mode:"history",base:"/",routes:x}),P=U,k=r("2106"),R=r.n(k);n["a"].use(R.a,h.a),n["a"].config.productionTip=!1,new n["a"]({router:P,render:function(e){return e(c)}}).$mount("#app");var C=localStorage.getItem("user-token");C&&(h.a.defaults.headers.common["Authorization"]="Bearer "+C)},"5c0b":function(e,t,r){"use strict";r("9c0c")},"756a":function(e,t,r){"use strict";r("dd58")},"9c0c":function(e,t,r){},cf05:function(e,t,r){e.exports=r.p+"static/img/logo.82b9c7a5.png"},dd58:function(e,t,r){}});
//# sourceMappingURL=app.bb096161.js.map