const { createApp } = Vue


createApp({
    data() {
        return {
            students:[],
            courses:[],
            firstName:'',
            lastName:'',
            email:'',
            password:'',

            studentId: '',

            newFirstName: '',
            newLastName:'',
            newEmail:'',
            newPassword:'',



        }
    },
    created() {
        this.loadStudents()
    },
    mounted() {

    },
    methods: {

        loadStudents() {
            axios.get('/api/students')
                .then(res => {
                    this.students = res.data
                    console.log(this.students);
                })
        },

        addStudent(){
            axios.post("/api/students",`firstName=${this.firstName}&lastName=${this.lastName}&email=${this.email}&password=${this.password}`)
            .then(()=>alert("Student Created!"))
            .then(()=>window.location.reload())
            .catch(error=>alert(`${error.response.data}`))
        },

        deleteStudent(student){
            axios.delete("/api/students/delete/"+student.id)
            .then(()=>alert("Student Deleted"))
            .then(()=>window.location.reload())
            .catch(error=>alert(`${error.response.data}`))
        },

        updateStudentId(student){
            this.studentId = student.id;
        },

        editStudent(){
            axios.patch("/api/students/update/"+this.studentId, `firstName=${this.newFirstName}&lastName=${this.newLastName}&email=${this.newEmail}&password=${this.newPassword}`)
            .then(()=>alert("Student Edited"))
            .then(()=>window.location.reload())
            .catch(error=>alert(`${error.response.data}`))
        }
    },
    computed: {

    },
}).mount('#app')

