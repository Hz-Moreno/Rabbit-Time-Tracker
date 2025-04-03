<template>
  <div class="min-h-screen bg-gray-100 flex flex-col justify-center py-12 sm:px-6 lg:px-8">
    <div class="sm:mx-auto sm:w-full sm:max-w-md">
      <!--      <img class="mx-auto h-12 w-auto" src="/api/placeholder/48/48" alt="Company logo" /> -->
      <h2 class="mt-6 text-center text-3xl font-extrabold text-gray-900">
        Create your account
      </h2>
      <p class="mt-2 text-center text-sm text-gray-600">
        Or
        <a href="#" class="font-medium text-indigo-600 hover:text-indigo-500">
          sign in to your existing account
        </a>
      </p>
    </div>

    <div class="mt-8 sm:mx-auto sm:w-full sm:max-w-md">
      <div class="bg-white py-8 px-4 shadow sm:rounded-lg sm:px-10">
        <form class="space-y-6" @submit.prevent="handleRegister">
          <div class="grid grid-cols-1 gap-6 sm:grid-cols-2">
            <div>
              <label for="first-name" class="block text-sm font-medium text-gray-700">
                First name
              </label>
              <div class="mt-1">
                <input
                  id="first-name"
                  v-model="firstName"
                  name="first-name"
                  type="text"
                  autocomplete="given-name"
                  required
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                />
              </div>
            </div>

            <div>
              <label for="last-name" class="block text-sm font-medium text-gray-700">
                Last name
              </label>
              <div class="mt-1">
                <input
                  id="last-name"
                  v-model="lastName"
                  name="last-name"
                  type="text"
                  autocomplete="family-name"
                  required
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                />
              </div>
            </div>
          </div>

          <div>
            <label for="email" class="block text-sm font-medium text-gray-700">
              Email address
            </label>
            <div class="mt-1">
              <input
                id="email"
                v-model="email"
                name="email"
                type="email"
                autocomplete="email"
                required
                class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
              />
            </div>
            <p v-if="emailError" class="mt-2 text-sm text-red-600">{{ emailError }}</p>
          </div>

          <div>
            <label for="password" class="block text-sm font-medium text-gray-700">
              Password
            </label>
            <div class="mt-1">
              <input
                id="password"
                v-model="password"
                name="password"
                type="password"
                autocomplete="new-password"
                required
                class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
              />
            </div>
            <p v-if="passwordError" class="mt-2 text-sm text-red-600">{{ passwordError }}</p>
          </div>

          <div>
            <label for="confirm-password" class="block text-sm font-medium text-gray-700">
              Confirm password
            </label>
            <div class="mt-1">
              <input
                id="confirm-password"
                v-model="confirmPassword"
                name="confirm-password"
                type="password"
                autocomplete="new-password"
                required
                class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
              />
            </div>
            <p v-if="confirmPasswordError" class="mt-2 text-sm text-red-600">{{ confirmPasswordError }}</p>
          </div>

          <div class="flex items-center">
            <input
              id="terms"
              v-model="termsAccepted"
              name="terms"
              type="checkbox"
              required
              class="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded"
            />
            <label for="terms" class="ml-2 block text-sm text-gray-900">
              I agree to the
              <a href="#" class="font-medium text-indigo-600 hover:text-indigo-500">Terms of Service</a>
              and
              <a href="#" class="font-medium text-indigo-600 hover:text-indigo-500">Privacy Policy</a>
            </label>
          </div>
          <p v-if="termsError" class="mt-2 text-sm text-red-600">{{ termsError }}</p>

          <div>
            <button
              type="submit"
              :disabled="isLoading"
              class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
            >
              <span v-if="isLoading">Creating account...</span>
              <span v-else>Create account</span>
            </button>
          </div>
        </form>

        <div class="mt-6">
          <div class="relative">
            <div class="absolute inset-0 flex items-center">
              <div class="w-full border-t border-gray-300"></div>
            </div>
            <div class="relative flex justify-center text-sm">
              <span class="px-2 bg-white text-gray-500">
                Or register with
              </span>
            </div>
          </div>

          <div class="mt-6 grid grid-cols-2 gap-3">
            <div>
              <a href="#" class="w-full inline-flex justify-center py-2 px-4 border border-gray-300 rounded-md shadow-sm bg-white text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span>Google</span>
              </a>
            </div>
            <div>
              <a href="#" class="w-full inline-flex justify-center py-2 px-4 border border-gray-300 rounded-md shadow-sm bg-white text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span>GitHub</span>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      firstName: '',
      lastName: '',
      email: '',
      password: '',
      confirmPassword: '',
      termsAccepted: false,
      isLoading: false,
      emailError: '',
      passwordError: '',
      confirmPasswordError: '',
      termsError: ''
    }
  },
  methods: {
    validateEmail() {
      this.emailError = ''
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
      if (!emailRegex.test(this.email)) {
        this.emailError = 'Please enter a valid email address'
        return false
      }
      return true
    },
    validatePassword() {
      this.passwordError = ''
      if (this.password.length < 8) {
        this.passwordError = 'Password must be at least 8 characters'
        return false
      }

      // Check for password strength - requires at least one number and one special character
      const hasNumber = /\d/.test(this.password)
      const hasSpecial = /[!@#$%^&*(),.?":{}|<>]/.test(this.password)

      if (!hasNumber || !hasSpecial) {
        this.passwordError = 'Password must contain at least one number and one special character'
        return false
      }

      return true
    },
    validateConfirmPassword() {
      this.confirmPasswordError = ''
      if (this.password !== this.confirmPassword) {
        this.confirmPasswordError = 'Passwords do not match'
        return false
      }
      return true
    },
    validateTerms() {
      this.termsError = ''
      if (!this.termsAccepted) {
        this.termsError = 'You must accept the terms and conditions'
        return false
      }
      return true
    },
    async handleRegister() {
      // Validate all inputs
      const isEmailValid = this.validateEmail()
      const isPasswordValid = this.validatePassword()
      const isConfirmPasswordValid = this.validateConfirmPassword()
      const areTermsAccepted = this.validateTerms()

      if (!isEmailValid || !isPasswordValid || !isConfirmPasswordValid || !areTermsAccepted) {
        return
      }

      this.isLoading = true

      try {
        // Simulate API call with timeout
        await new Promise(resolve => setTimeout(resolve, 1500))

        // Here you would normally make an API call to register
        // const response = await authService.register({
        //   firstName: this.firstName,
        //   lastName: this.lastName,
        //   email: this.email,
        //   password: this.password
        // })

        console.log('Registration successful', {
          firstName: this.firstName,
          lastName: this.lastName,
          email: this.email,
          password: '********' // Don't log actual passwords
        })

        // Redirect to login page or dashboard
        // this.$router.push('/login')
      } catch (error) {
        console.error('Registration failed', error)
        // Handle errors - show message to user
      } finally {
        this.isLoading = false
      }
    }
  }
}
</script>
