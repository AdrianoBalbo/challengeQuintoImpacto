const { createApp } = Vue


createApp({
    data() {
        return {
            teacherCourses:[],
            courses: [],
            courseName: [],
            dayTime: [],
            teachers: [],

            courseToAdd:'',


        }
    },
    created() {
        this.loadTeacherCourses()
    },
    mounted() {

    },
    methods: {

        loadTeacherCourses() {
            axios.get('/api/courses/getteachers')
                .then(res => {
                    this.teacherCourses = res.data
                })
        },



        addCourse(){
            axios.post('/api/courses',`courseName=${this.courseToAdd}&dayTime=${this.dayTime}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(res=>window.location.reload())
            .catch(error=>alert(`${error.response.data}`))

        },
    },
    computed: {

    },
}).mount('#app')

