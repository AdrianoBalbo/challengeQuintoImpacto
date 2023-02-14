const { createApp } = Vue


createApp({
    data() {
        return {
            logContainer: document.getElementById("app"),
            userMail: '',
            userPassword: '',
        }
    },
    created() {

    },
    mounted() {

    },
    methods: {
        login(){
            axios.post('/api/login', `email=${this.userMail}&password=${this.userPassword}`)
            .then(response => {
                window.location.href = "./courses.html"
            })
            .catch(()=> swal("Wrong email or password. Try again"))

        },
    },
    computed: {

    },
}).mount('#app')


