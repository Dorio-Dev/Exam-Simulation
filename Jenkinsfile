pipeline {
    agent { node { label 'fargate-mip-be' } }
    stages{
        stage('CheckOut'){
            steps {
                checkout scm
            }
        }
    }
}