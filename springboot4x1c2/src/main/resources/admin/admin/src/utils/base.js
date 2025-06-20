const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot4x1c2/",
            name: "springboot4x1c2",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot4x1c2/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于hive旅游数据的分析与应用"
        } 
    }
}
export default base
