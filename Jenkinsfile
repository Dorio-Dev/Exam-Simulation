node {
    stage('CheckOut'){
        checkout scm
    }
    stage('bootJar'){
        sh './gradlew bootJar'
    }
}