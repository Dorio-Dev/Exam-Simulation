node {
    stage('CheckOut'){
        checkout scm
    }
    stage('bootJar'){
        sh 'chmod +x ./gradlew'
        sh './gradlew bootJar'
    }
    withCredentials([sshUserPrivateKey(credentialsId: "exam", keyFileVariable: 'keyfile')]) {
        def remote = [:]
        remote.name = 'exam-ec2'
        remote.user = 'ec2-user'
        remote.identityFile = keyfile
        remote.host = '172.31.33.160'
        remote.allowAnyHosts = true
        stage('jar Upload'){
            sh 'scp -o StrictHostKeyChecking=no -i ${keyfile} build/libs/exam-0.1.1-SNAPSHOT.jar ec2-user@172.31.33.160:/home/ec2-user/'
        }
        stage('stop app'){
            sshCommand remote: remote, command: '/home/ec2-user/stop.sh'
            sshCommand
        }
        stage('start app'){

        }
    }
}