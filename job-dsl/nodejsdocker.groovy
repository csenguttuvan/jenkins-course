job('Groovy-edit2') {
    scm {
        git('git://github.com/csenguttuvan/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('csenguttuvan')
            node / gitConfigEmail('chris.senguttuvan@kaltura.com')
        }
    }
    triggers {
        scm('*H/1 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('csenguttuvan/nodejs')
            tag('')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
