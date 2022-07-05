pipeline{
    agent any

    stages{
        stage('Build'){
            steps{
                git 'https://github.com/otenkoo/Assignment-7-CEN-4802C.git'
                bat './mvnw clean compile'
            }
        }
    }
}
