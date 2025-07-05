# Gratitude Journal App - CI/CD Pipeline Setup

This repository contains a comprehensive CI/CD pipeline setup for the Gratitude Journal application, which consists of an Angular frontend and a Spring Boot backend.

## 🏗️ Architecture Overview

- **Frontend**: Angular 18 (TypeScript)
- **Backend**: Spring Boot 3.5.3 (Java 21)
- **Build Tools**: Maven (Backend), npm (Frontend)
- **Containerization**: Docker
- **CI/CD**: GitHub Actions

## 📁 Project Structure

```
gratitude-journal-app/
├── .github/
│   └── workflows/
│       ├── frontend-ci-cd.yml      # Frontend-specific CI/CD
│       ├── backend-ci-cd.yml       # Backend-specific CI/CD
│       └── full-stack-ci-cd.yml    # Combined CI/CD pipeline
├── gratitude-journal-front-end/
│   └── gratitude-jounal-ui/        # Angular application
├── graitude-journal-back-end/      # Spring Boot application
│   ├── Dockerfile                  # Backend containerization
│   ├── .dockerignore              # Docker ignore rules
│   └── owasp-suppressions.xml     # Security scan suppressions
└── CI-CD-README.md                # This file
```

## 🚀 CI/CD Workflows

### 1. Frontend CI/CD Pipeline (`frontend-ci-cd.yml`)

**Triggers**: Changes to `gratitude-journal-front-end/` directory or workflow file

**Stages**:
- **Lint and Test**: Code linting and unit tests
- **Build**: Production build with optimization
- **Security Scan**: npm audit and Snyk vulnerability scan
- **Deploy**: Development (develop branch) and Production (main branch)

### 2. Backend CI/CD Pipeline (`backend-ci-cd.yml`)

**Triggers**: Changes to `graitude-journal-back-end/` directory or workflow file

**Stages**:
- **Test and Build**: Unit tests and JAR compilation
- **Security Scan**: OWASP dependency check
- **Docker Build**: Container image creation and push
- **Deploy**: Development and Production deployments

### 3. Full Stack CI/CD Pipeline (`full-stack-ci-cd.yml`)

**Triggers**: Any changes to the repository

**Stages**:
- **Frontend Pipeline**: Angular build and test
- **Backend Pipeline**: Spring Boot build and test
- **Integration Tests**: End-to-end testing
- **Security Scan**: Combined security analysis
- **Deploy**: Coordinated deployment of both services

## ⚙️ Configuration

### Required Secrets

Add the following secrets to your GitHub repository:

```bash
# Docker Hub credentials (for container registry)
DOCKER_USERNAME=your-docker-username
DOCKER_PASSWORD=your-docker-password

# Snyk security token (optional)
SNYK_TOKEN=your-snyk-token

# Deployment credentials (add as needed)
AWS_ACCESS_KEY_ID=your-aws-access-key
AWS_SECRET_ACCESS_KEY=your-aws-secret-key
```

### Environment Variables

The workflows use the following environment variables:

- `NODE_VERSION`: '18' (for Angular)
- `JAVA_VERSION`: '21' (for Spring Boot)
- `ANGULAR_VERSION`: '18'

## 🔧 Setup Instructions

### 1. Repository Setup

1. Ensure your repository has the correct branch structure:
   - `main`: Production branch
   - `develop`: Development branch

2. Add the required secrets to your GitHub repository:
   - Go to Settings → Secrets and variables → Actions
   - Add the secrets listed above

### 2. Environment Configuration

Create environments in GitHub:
1. Go to Settings → Environments
2. Create `development` and `production` environments
3. Configure protection rules as needed

### 3. Branch Protection

Set up branch protection rules:
1. Go to Settings → Branches
2. Add rule for `main` and `develop` branches
3. Enable:
   - Require status checks to pass
   - Require branches to be up to date
   - Require pull request reviews

## 🚀 Deployment

### Development Deployment

- **Trigger**: Push to `develop` branch
- **Environment**: Development
- **Artifacts**: Frontend build + Backend JAR
- **Health Check**: Automatic verification

### Production Deployment

- **Trigger**: Push to `main` branch
- **Environment**: Production
- **Artifacts**: Frontend build + Backend JAR
- **Health Check**: Automatic verification

## 🔍 Monitoring and Debugging

### Workflow Artifacts

The pipelines generate several artifacts:
- `frontend-build`: Angular production build
- `backend-jar`: Spring Boot JAR file
- `test-results`: Test reports
- `coverage-reports`: Code coverage reports
- `security-report`: Security scan results

### Logs and Debugging

1. **Workflow Logs**: Available in the Actions tab
2. **Artifact Downloads**: Available for 7-30 days
3. **Security Reports**: Stored as artifacts

## 🛡️ Security Features

### Frontend Security
- npm audit for dependency vulnerabilities
- Snyk security scanning
- Code coverage reporting

### Backend Security
- OWASP dependency check
- Maven dependency verification
- Container security scanning

## 📊 Best Practices

### Code Quality
- Automated linting and formatting
- Unit test coverage requirements
- Integration test validation

### Security
- Regular dependency updates
- Vulnerability scanning
- Container security

### Performance
- Multi-stage Docker builds
- Caching for faster builds
- Optimized production builds

## 🔧 Customization

### Adding New Environments

1. Create a new environment in GitHub
2. Add deployment job to workflows
3. Configure environment-specific variables

### Custom Deployment Scripts

Replace the placeholder deployment commands in the workflows:

```yaml
- name: Deploy to environment
  run: |
    # Add your deployment commands here
    # Example: AWS CLI, kubectl, etc.
```

### Adding New Tools

To add new tools (e.g., SonarQube, additional security scanners):

1. Add the tool to the appropriate workflow
2. Configure tool-specific secrets
3. Update documentation

## 🐛 Troubleshooting

### Common Issues

1. **Build Failures**:
   - Check Node.js/Java version compatibility
   - Verify dependency versions
   - Review build logs

2. **Deployment Failures**:
   - Verify environment secrets
   - Check network connectivity
   - Review deployment logs

3. **Security Scan Failures**:
   - Review vulnerability reports
   - Update dependencies
   - Add suppressions if needed

### Getting Help

1. Check workflow logs in GitHub Actions
2. Review artifact contents
3. Verify secret configuration
4. Test locally before pushing

## 📈 Performance Optimization

### Build Optimization
- Dependency caching
- Parallel job execution
- Multi-stage builds

### Deployment Optimization
- Blue-green deployments
- Rolling updates
- Health check integration

## 🔄 Maintenance

### Regular Tasks
- Update dependency versions
- Review security reports
- Monitor build times
- Update workflow versions

### Version Updates
- Node.js version updates
- Java version updates
- GitHub Actions updates
- Docker base image updates

---

For more information, refer to the individual workflow files and the GitHub Actions documentation. 