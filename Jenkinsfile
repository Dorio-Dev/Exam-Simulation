node {
    stage('CheckOut'){
        checkout scm
    }
    stage('bootJar'){
        sh 'chmod +x ./gradlew'
        sh './gradlew bootJar'
    }
}