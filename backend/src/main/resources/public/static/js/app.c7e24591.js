(function(e){function t(t){for(var r,o,a=t[0],l=t[1],u=t[2],d=0,b=[];d<a.length;d++)o=a[d],Object.prototype.hasOwnProperty.call(n,o)&&n[o]&&b.push(n[o][0]),n[o]=0;for(r in l)Object.prototype.hasOwnProperty.call(l,r)&&(e[r]=l[r]);i&&i(t);while(b.length)b.shift()();return s.push.apply(s,u||[]),c()}function c(){for(var e,t=0;t<s.length;t++){for(var c=s[t],r=!0,a=1;a<c.length;a++){var l=c[a];0!==n[l]&&(r=!1)}r&&(s.splice(t--,1),e=o(o.s=c[0]))}return e}var r={},n={app:0},s=[];function o(t){if(r[t])return r[t].exports;var c=r[t]={i:t,l:!1,exports:{}};return e[t].call(c.exports,c,c.exports,o),c.l=!0,c.exports}o.m=e,o.c=r,o.d=function(e,t,c){o.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:c})},o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},o.t=function(e,t){if(1&t&&(e=o(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var c=Object.create(null);if(o.r(c),Object.defineProperty(c,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)o.d(c,r,function(t){return e[t]}.bind(null,r));return c},o.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(t,"a",t),t},o.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},o.p="/";var a=window["webpackJsonp"]=window["webpackJsonp"]||[],l=a.push.bind(a);a.push=t,a=a.slice();for(var u=0;u<a.length;u++)t(a[u]);var i=l;s.push([0,"chunk-vendors"]),c()})({0:function(e,t,c){e.exports=c("cd49")},"1c23":function(e,t,c){"use strict";c("26ad")},"26ad":function(e,t,c){},"6d1d":function(e,t,c){},"70df":function(e,t,c){},8884:function(e,t,c){},ad5f:function(e,t,c){e.exports=c.p+"static/img/spring-boot-vuejs-logo.00da5c74.png"},cc6b:function(e,t,c){"use strict";c("6d1d")},cd49:function(e,t,c){"use strict";c.r(t);c("e260"),c("e6cf"),c("cca6"),c("a79d");var r=c("7a23"),n={id:"nav"},s=Object(r["f"])("Hello"),o=Object(r["f"])(" | "),a=Object(r["f"])("Service"),l=Object(r["f"])(" | "),u=Object(r["f"])("Bootstrap"),i=Object(r["f"])(" | "),d=Object(r["f"])("User"),b=Object(r["f"])(" | "),p=Object(r["f"])("Login"),g=Object(r["f"])(" | "),O=Object(r["f"])("Protected");function j(e,t){var c=Object(r["w"])("router-link"),j=Object(r["w"])("router-view");return Object(r["p"])(),Object(r["d"])(r["a"],null,[Object(r["g"])("div",n,[Object(r["g"])(c,{to:"/"},{default:Object(r["C"])((function(){return[s]})),_:1}),o,Object(r["g"])(c,{to:"/callservice"},{default:Object(r["C"])((function(){return[a]})),_:1}),l,Object(r["g"])(c,{to:"/bootstrap"},{default:Object(r["C"])((function(){return[u]})),_:1}),i,Object(r["g"])(c,{to:"/user"},{default:Object(r["C"])((function(){return[d]})),_:1}),b,Object(r["g"])(c,{to:"/login"},{default:Object(r["C"])((function(){return[p]})),_:1}),g,Object(r["g"])(c,{to:"/protected"},{default:Object(r["C"])((function(){return[O]})),_:1})]),Object(r["g"])(j)],64)}c("ecfb");const f={};f.render=j;var h=f,v=c("6c02"),m=c("ad5f"),y=c.n(m),w={class:"home"},S=Object(r["g"])("img",{alt:"Vue with Spring logo",src:y.a},null,-1);function k(e,t,c,n,s,o){var a=Object(r["w"])("HelloSpringWorld");return Object(r["p"])(),Object(r["d"])("div",w,[S,Object(r["g"])(a,{hellomsg:"Welcome to your Vue.js (+ TypeScript) powered Spring Boot App"})])}var R=Object(r["F"])("data-v-e9c99df4");Object(r["s"])("data-v-e9c99df4");var C={class:"hello"},U=Object(r["g"])("h2",null,"See the sources here: ",-1),T=Object(r["g"])("h3",null,"This site contains more stuff :)",-1),_=Object(r["g"])("li",null,"HowTo call REST-Services:",-1),N=Object(r["f"])("/callservice"),P=Object(r["g"])("li",null,"HowTo to play around with Bootstrap UI components:",-1),A=Object(r["f"])("/bootstrap"),H=Object(r["g"])("li",null,"HowTo to interact with the Spring Boot database backend:",-1),I=Object(r["f"])("/user"),E=Object(r["g"])("li",null,"Login to the secured part of the application",-1),x=Object(r["f"])("/login"),L=Object(r["g"])("li",null,"A secured part of this application:",-1),B=Object(r["f"])("/protected");Object(r["q"])();var q=R((function(e,t,c,n,s,o){var a=Object(r["w"])("router-link");return Object(r["p"])(),Object(r["d"])("div",C,[Object(r["g"])("h1",null,Object(r["y"])(c.hellomsg),1),U,T,Object(r["g"])("ul",null,[_,Object(r["g"])("li",null,[Object(r["g"])(a,{to:"/callservice"},{default:R((function(){return[N]})),_:1})]),P,Object(r["g"])("li",null,[Object(r["g"])(a,{to:"/bootstrap"},{default:R((function(){return[A]})),_:1})]),H,Object(r["g"])("li",null,[Object(r["g"])(a,{to:"/user"},{default:R((function(){return[I]})),_:1})]),E,Object(r["g"])("li",null,[Object(r["g"])(a,{to:"/login"},{default:R((function(){return[x]})),_:1})]),L,Object(r["g"])("li",null,[Object(r["g"])(a,{to:"/protected"},{default:R((function(){return[B]})),_:1})])])])})),F={name:"HelloSpringWorld",props:{hellomsg:{type:String,required:!0}}};c("f36d");F.render=q,F.__scopeId="data-v-e9c99df4";var D=F,V=Object(r["h"])({name:"Home",components:{HelloSpringWorld:D}});V.render=k;var M=V,W=Object(r["F"])("data-v-cddfe2c0");Object(r["s"])("data-v-cddfe2c0");var J={class:"service"},Y=Object(r["g"])("h2",null,"REST service call results",-1);Object(r["q"])();var $=W((function(e,t,c,n,s,o){return Object(r["p"])(),Object(r["d"])("div",J,[Object(r["g"])("h1",null,Object(r["y"])(e.msg),1),Y,Object(r["g"])("button",{onClick:t[1]||(t[1]=function(t){return e.callHelloApi()})},"CALL Spring Boot REST backend service"),Object(r["g"])("h4",null,"Backend response: "+Object(r["y"])(e.backendResponse),1)])})),G=c("bc3a"),z=c.n(G),K=z.a.create({baseURL:"/api",timeout:1e3,headers:{"Content-Type":"application/json"}}),Q={hello:function(){return K.get("/hello")},getUser:function(e){return K.get("/user/"+e)},createUser:function(e,t){return K.post("/user/"+e+"/"+t)},getSecured:function(e,t){return K.get("/secured/",{auth:{username:e,password:t}})}},X=Object(r["h"])({name:"Service",data:function(){return{msg:"HowTo call REST-Services:",backendResponse:"",errors:[]}},methods:{callHelloApi:function(){var e=this;Q.hello().then((function(t){e.backendResponse=t.data,console.log(t.data)})).catch((function(t){e.errors.push(t)}))}}});c("cc6b");X.render=$,X.__scopeId="data-v-cddfe2c0";var Z=X,ee=Object(r["F"])("data-v-dd18674e");Object(r["s"])("data-v-dd18674e");var te={class:"bootstrap"},ce=Object(r["g"])("h5",null,"REST service call are easy to do with Vue.js, if you know how to do it.",-1),re=Object(r["g"])("p",null,null,-1),ne=Object(r["g"])("h6",null,[Object(r["g"])("span",{class:"badge bg-primary"}," Let´s go!"),Object(r["f"])(" Call a Spring Boot REST backend service, by clicking a button:")],-1),se=Object(r["g"])("p",null,null,-1),oe=Object(r["g"])("p",null,null,-1),ae=Object(r["f"])("Backend response: "),le=Object(r["g"])("button",{class:"btn btn-secondary","data-bs-toggle":"collapse","data-bs-target":"#collapseOuter"},"Show Response details",-1),ue=Object(r["g"])("p",null,null,-1),ie={class:"collapse",id:"collapseOuter"},de={class:"card card-body"},be=Object(r["f"])(" The Response hat this details "),pe=Object(r["g"])("button",{class:"btn btn-primary","data-bs-toggle":"collapse","data-bs-target":"#collapseInnerStatusCode"},"HTTP Status",-1),ge={class:"collapse",id:"collapseInnerStatusCode"},Oe={class:"card card-body"},je={class:"card card-body"},fe=Object(r["g"])("button",{class:"btn btn-warning","data-bs-toggle":"collapse","data-bs-target":"#collapseInnerHeaders"},"HTTP Headers",-1),he={class:"collapse",id:"collapseInnerHeaders"},ve={key:0},me={class:"card card-body"},ye=Object(r["g"])("button",{class:"btn btn-danger","data-bs-toggle":"collapse","data-bs-target":"#collapseInnerResponseConfig"},"Full Request configuration",-1),we={class:"collapse",id:"collapseInnerResponseConfig"},Se={class:"card card-body"};Object(r["q"])();var ke=ee((function(e,t,c,n,s,o){return Object(r["p"])(),Object(r["d"])("div",te,[Object(r["g"])("h1",null,Object(r["y"])(e.msg),1),ce,re,ne,se,Object(r["g"])("button",{class:"btn btn-success",onClick:t[1]||(t[1]=function(t){return e.callHelloApi()}),id:"btnCallHello"},"/hello (GET)"),oe,Object(r["g"])("h4",null,[ae,Object(r["g"])("span",{class:"alert alert-primary",role:"alert",show:e.showResponse,dismissible:"",onDismissed:t[2]||(t[2]=function(t){return e.showResponse=!1})},Object(r["y"])(e.backendResponse),41,["show"])]),le,ue,Object(r["g"])("div",ie,[Object(r["g"])("div",de,[be,pe,Object(r["g"])("div",ge,[Object(r["g"])("div",Oe,"Status: "+Object(r["y"])(e.httpStatusCode),1),Object(r["g"])("div",je,"Statustext: "+Object(r["y"])(e.httpStatusText),1)]),fe,Object(r["g"])("div",he,[e.headers&&e.headers.length?(Object(r["p"])(),Object(r["d"])("p",ve,[(Object(r["p"])(!0),Object(r["d"])(r["a"],null,Object(r["v"])(e.headers,(function(e){return Object(r["p"])(),Object(r["d"])("li",null,[Object(r["g"])("div",me,"Header: "+Object(r["y"])(e.valueOf()),1)])})),256))])):Object(r["e"])("",!0)]),ye,Object(r["g"])("div",we,[Object(r["g"])("div",Se,"Config: "+Object(r["y"])(e.responseConfig),1)])])])])})),Re=Object(r["h"])({name:"Bootstrap",data:function(){return{msg:"Nice Bootstrap candy!",showResponse:!1,backendResponse:"",responseConfig:"",httpStatusCode:0,httpStatusText:"",headers:["Noting here atm. Did you call the Service?"],errors:[]}},methods:{callHelloApi:function(){var e=this;Q.hello().then((function(t){e.backendResponse=t.data,e.httpStatusCode=t.status,e.httpStatusText=t.statusText,e.headers=t.headers,e.responseConfig=t.config,e.showResponse=!0})).catch((function(t){e.errors.push(t)}))}}});c("1c23");Re.render=ke,Re.__scopeId="data-v-dd18674e";var Ce=Re,Ue=Object(r["F"])("data-v-ab1c889c");Object(r["s"])("data-v-ab1c889c");var Te={class:"user"},_e=Object(r["g"])("h1",null,"Create User",-1),Ne=Object(r["g"])("h3",null,"Just some database interaction...",-1),Pe={key:0},Ae={key:2};Object(r["q"])();var He=Ue((function(e,t,c,n,s,o){return Object(r["p"])(),Object(r["d"])("div",Te,[_e,Ne,Object(r["D"])(Object(r["g"])("input",{type:"text","onUpdate:modelValue":t[1]||(t[1]=function(t){return e.user.firstName=t}),placeholder:"first name"},null,512),[[r["A"],e.user.firstName]]),Object(r["D"])(Object(r["g"])("input",{type:"text","onUpdate:modelValue":t[2]||(t[2]=function(t){return e.user.lastName=t}),placeholder:"last name"},null,512),[[r["A"],e.user.lastName]]),Object(r["g"])("button",{onClick:t[3]||(t[3]=function(t){return e.createNewUser()})},"Create User"),e.showResponse?(Object(r["p"])(),Object(r["d"])("div",Pe,[Object(r["g"])("h6",null,"User created with Id: "+Object(r["y"])(e.user.id),1)])):Object(r["e"])("",!0),e.showResponse?(Object(r["p"])(),Object(r["d"])("button",{key:1,onClick:t[4]||(t[4]=function(t){return e.retrieveUser()})},"Retrieve user "+Object(r["y"])(e.user.id)+" data from database",1)):Object(r["e"])("",!0),e.showRetrievedUser?(Object(r["p"])(),Object(r["d"])("h4",Ae,"Retrieved User "+Object(r["y"])(e.retrievedUser.firstName)+" "+Object(r["y"])(e.retrievedUser.lastName),1)):Object(r["e"])("",!0)])})),Ie=Object(r["h"])({name:"User",data:function(){return{errors:[],user:{id:0,firstName:"",lastName:""},showResponse:!1,retrievedUser:{id:0,firstName:"",lastName:""},showRetrievedUser:!1}},methods:{createNewUser:function(){var e=this;Q.createUser(this.user.firstName,this.user.lastName).then((function(t){e.user.id=t.data,console.log("Created new User with Id "+t.data),e.showResponse=!0})).catch((function(t){e.errors.push(t)}))},retrieveUser:function(){var e=this;Q.getUser(this.user.id).then((function(t){e.retrievedUser=t.data,e.showRetrievedUser=!0})).catch((function(t){e.errors.push(t)}))}}});c("ffab");Ie.render=He,Ie.__scopeId="data-v-ab1c889c";var Ee=Ie,xe={key:0,class:"unprotected"},Le=Object(r["g"])("h1",null,[Object(r["g"])("span",{class:"badge bg-danger"},"You don't have rights here, mate :D")],-1),Be=Object(r["g"])("h5",null,"Seems that you don't have access rights... ",-1),qe={key:1,class:"unprotected"},Fe=Object(r["g"])("h1",null,[Object(r["g"])("span",{class:"badge bg-warning text-dark"},"Please login to get access!")],-1),De=Object(r["g"])("h5",null,"You're not logged in - so you don't see much here. Try to log in:",-1),Ve=Object(r["g"])("button",{type:"submit",class:"btn btn-primary"},"Login",-1),Me={key:0,class:"error"};function We(e,t,c,n,s,o){return e.loginError?(Object(r["p"])(),Object(r["d"])("div",xe,[Le,Be])):(Object(r["p"])(),Object(r["d"])("div",qe,[Fe,De,Object(r["g"])("form",{onSubmit:t[3]||(t[3]=Object(r["E"])((function(t){return e.callLogin()}),["prevent"]))},[Object(r["D"])(Object(r["g"])("input",{type:"text",placeholder:"username","onUpdate:modelValue":t[1]||(t[1]=function(t){return e.user=t})},null,512),[[r["A"],e.user]]),Object(r["D"])(Object(r["g"])("input",{type:"password",placeholder:"password","onUpdate:modelValue":t[2]||(t[2]=function(t){return e.password=t})},null,512),[[r["A"],e.password]]),Ve,e.error?(Object(r["p"])(),Object(r["d"])("p",Me,"Bad login information")):Object(r["e"])("",!0)],32)]))}var Je=Object(r["h"])({name:"Login",data:function(){return{loginError:!1,user:"",password:"",error:!1,errors:[]}},methods:{callLogin:function(){var e=this;this.errors=[],this.$store.dispatch("login",{user:this.user,password:this.password}).then((function(){e.$router.push("/Protected")})).catch((function(t){e.loginError=!0,e.errors.push(t),e.error=!0}))}}});Je.render=We;var Ye=Je,$e=Object(r["g"])("h1",null,[Object(r["g"])("span",{class:"badge bg-success"},"YEAH you made it!")],-1),Ge=Object(r["g"])("h5",null,"If you're able to read this, you've successfully logged in and redirected to this protected site :)",-1),ze=Object(r["g"])("p",null,null,-1),Ke={key:0},Qe=Object(r["g"])("span",{class:"badge bg-success"},"API call",-1),Xe=Object(r["g"])("span",{class:"badge bg-success"},"successful",-1),Ze={key:1},et=Object(r["g"])("span",{class:"badge bg-warning"},"API call",-1),tt=Object(r["g"])("span",{class:"badge bg-warning"},"NOT successful",-1);function ct(e,t,c,n,s,o){return Object(r["p"])(),Object(r["d"])("div",null,[$e,Ge,Object(r["g"])("button",{class:"btn btn-primary",onClick:t[1]||(t[1]=function(t){return e.getSecuredTextFromBackend()})},"Call the secured API"),ze,e.securedApiCallSuccess?(Object(r["p"])(),Object(r["d"])("div",Ke,[Qe,Object(r["f"])(" Full response: "+Object(r["y"])(e.backendResponse)+" ",1),Xe])):Object(r["e"])("",!0),e.errors?(Object(r["p"])(),Object(r["d"])("div",Ze,[et,Object(r["f"])(" "+Object(r["y"])(e.errors)+" ",1),tt])):Object(r["e"])("",!0)])}c("d3b7");var rt=c("5502"),nt=Object(rt["a"])({state:{loginSuccess:!1,loginError:!1,userName:null,userPass:null},mutations:{login_success:function(e,t){e.loginSuccess=!0,e.userName=t.userName,e.userPass=t.userPass},login_error:function(e,t){e.loginError=!0,e.userName=t.userName}},actions:{login:function(e,t){var c=e.commit,r=t.user,n=t.password;return new Promise((function(e,t){console.log("Accessing backend with user: '"+r),Q.getSecured(r,n).then((function(t){console.log("Response: '"+t.data+"' with Statuscode "+t.status),200==t.status&&(console.log("Login successful"),c("login_success",{userName:r,userPass:n})),e(t)})).catch((function(e){console.log("Error: "+e),c("login_error",{userName:r}),t("Invalid credentials!")}))}))}},getters:{isLoggedIn:function(e){return e.loginSuccess},hasLoginErrored:function(e){return e.loginError},getUserName:function(e){return e.userName},getUserPass:function(e){return e.userPass}}}),st=Object(r["h"])({name:"Protected",data:function(){return{backendResponse:"",securedApiCallSuccess:!1,errors:[]}},methods:{getSecuredTextFromBackend:function(){var e=this;Q.getSecured(nt.getters.getUserName,nt.getters.getUserPass).then((function(t){console.log("Response: '"+t.data+"' with Statuscode "+t.status),e.securedApiCallSuccess=!0,e.backendResponse=t.data})).catch((function(t){console.log("Error: "+t),e.errors.push(t)}))}}});st.render=ct;var ot=st,at=[{path:"/",component:M},{path:"/callservice",component:Z},{path:"/bootstrap",component:Ce},{path:"/user",component:Ee},{path:"/login",component:Ye},{path:"/protected",component:ot,meta:{requiresAuth:!0}},{path:"/:pathMatch(.*)*",redirect:"/"}],lt=Object(v["a"])({history:Object(v["b"])("/"),routes:at});lt.beforeEach((function(e,t,c){e.matched.some((function(e){return e.meta.requiresAuth}))?nt.getters.isLoggedIn?c():c({path:"/login"}):c()}));var ut=lt;c("ab8b"),c("7b17");Object(r["c"])(h).use(ut).use(nt).mount("#app")},d681:function(e,t,c){},ecfb:function(e,t,c){"use strict";c("70df")},f36d:function(e,t,c){"use strict";c("8884")},ffab:function(e,t,c){"use strict";c("d681")}});
//# sourceMappingURL=app.c7e24591.js.map