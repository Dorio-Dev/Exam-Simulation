node {
    stage('CheckOut'){
        checkout scm
    }
    stage('bootJar'){
        sh 'chmod +x ./gradlew'
        sh './gradlew bootJar'
    }
    withCredentials([sshUserPrivateKey(credentialsId: "exam", keyFileVariable: 'keyfile')]) {
        stage('jar Upload'){
            sh 'scp -o StrictHostKeyChecking=no -i ${keyfile} build/libs/exam-0.1.1-SNAPSHOT.jar ec2-user@172.31.33.160:/home/ec2-user/'
        }
    }
}