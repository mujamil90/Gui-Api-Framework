pipeline {
   options {
     disableConcurrentBuilds()
     buildDiscarder(logRotator(numToKeepStr: '10'))
           }
    agent any
    stages {
        stage('Build') {
            steps {

                git url: 'https://github.com/mujamil90/Gui-Api-Framework.git', branch: 'master',
                 credentialsId: 'github_creds'
            }
        }
    }
}
