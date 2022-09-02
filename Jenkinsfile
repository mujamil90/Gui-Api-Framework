pipeline {
    options {
     disableConcurrentBuilds()
     timestamps()
     buildDiscarder(logRotator(numToKeepStr: '10'))
      timeout(time: 15, unit: 'MINUTES')
           }
    agent any
    tools {
        maven 'maven-3.8.6'
    }


    parameters {
         string(name: 'branch', defaultValue: 'master', description: 'The branch to checkout')
         string(name: 'suiteXmlFile', defaultValue: 'GUI-Tests.xml', description: 'The branch test suite to execute')
    }

    stages {

         stage('Clean Workspace') {

            steps {
                echo "--------------------------------- Clean Jenkins Workspace --------------------------------"
                cleanWs()
            }
        }

        stage('Github Checkout') {
            steps {
                echo "--------------------------------- Github Checkout --------------------------------"
                // Get code from a GitHub repository
                git url: 'https://github.com/mujamil90/Gui-Api-Framework.git', branch: "${branch}",
                 credentialsId: 'github_creds'
            }
        }

     stage ('Test Execution') {
            steps {
                echo "--------------------------------- Execute Tests --------------------------------"
                sh "mvn  clean  test \
                -Dsurefire.suiteXmlFiles=${suiteXmlFile}"
            }
    }
    }

            post {
          always {
               echo "--------------------------------- Generating and Publishing Test Report --------------------------------"
            script {
              allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'allure-results']]
              ])
            }
          }
        }
}
