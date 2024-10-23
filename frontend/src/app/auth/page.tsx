'use client'

import { useState, FormEvent } from 'react'
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { FaGoogle } from 'react-icons/fa'
import { Eye, EyeOff } from 'lucide-react'

export default function AuthUI() {
  const [isLogin, setIsLogin] = useState(true)
  const [showPassword, setShowPassword] = useState(false)
  const [showConfirmPassword, setShowConfirmPassword] = useState(false)
  const [errors, setErrors] = useState<{ [key: string]: string }>({})

  const togglePasswordVisibility = () => setShowPassword(!showPassword)
  const toggleConfirmPasswordVisibility = () => setShowConfirmPassword(!showConfirmPassword)

  const validateForm = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault()
    const formData = new FormData(e.currentTarget)
    const newErrors: { [key: string]: string } = {}

    // Validar campos del formulario de inicio de sesión
    if (isLogin) {
      if (!formData.get('email')) {
        newErrors.email = 'El correo electrónico es obligatorio'
      }
      if (!formData.get('password')) {
        newErrors.password = 'La contraseña es obligatoria'
      }
    } else {
      // Validar campos del formulario de registro
      if (!formData.get('firstName')) {
        newErrors.firstName = 'El nombre es obligatorio'
      }
      if (!formData.get('lastName')) {
        newErrors.lastName = 'El apellido es obligatorio'
      }
      if (!formData.get('email')) {
        newErrors.email = 'El correo electrónico es obligatorio'
      }
      if (!formData.get('confirmEmail')) {
        newErrors.confirmEmail = 'La confirmación del correo es obligatoria'
      }
      if (formData.get('email') !== formData.get('confirmEmail')) {
        newErrors.confirmEmail = 'Los correos electrónicos no coinciden'
      }
      if (!formData.get('password')) {
        newErrors.password = 'La contraseña es obligatoria'
      }
      if (!formData.get('confirmPassword')) {
        newErrors.confirmPassword = 'La confirmación de la contraseña es obligatoria'
      }
      if (formData.get('password') !== formData.get('confirmPassword')) {
        newErrors.confirmPassword = 'Las contraseñas no coinciden'
      }
    }

    setErrors(newErrors)

    if (Object.keys(newErrors).length === 0) {
      // Aquí iría la lógica para enviar el formulario
      console.log('Formulario válido, enviando datos...')
    }
  }

  return (
    <div className="min-h-screen w-full bg-black text-white flex items-center justify-center p-4">
      <div className="w-full max-w-md">
        <h1 className="text-3xl font-bold mb-2">{isLogin ? 'Bienvenido' : 'Registro'}</h1>
        <p className="text-gray-400 mb-8">
          {isLogin ? 'Inicia sesión para acceder a tu cuenta' : 'Crea una nueva cuenta'}
        </p>
        <div className="bg-white text-black p-8 rounded-lg shadow-lg">
          <form onSubmit={validateForm} noValidate className="space-y-4">
            {isLogin ? (
              <>
                <div>
                  <Label htmlFor="email" className="text-gray-700">Correo electrónico</Label>
                  <Input id="email" name="email" type="email" placeholder="tu@ejemplo.com" className="mt-1" required />
                  {errors.email && <p className="text-red-500 text-sm mt-1">{errors.email}</p>}
                </div>
                <div>
                  <div className="flex justify-between items-center">
                    <Label htmlFor="password" className="text-gray-700">Contraseña</Label>
                    <a href="#" className="text-sm text-gray-500 hover:text-black">¿Olvidaste?</a>
                  </div>
                  <div className="relative">
                    <Input 
                      id="password" 
                      name="password"
                      type={showPassword ? "text" : "password"} 
                      placeholder="Tu contraseña" 
                      className="mt-1 pr-10" 
                      required
                    />
                    <button
                      type="button"
                      onClick={togglePasswordVisibility}
                      className="absolute inset-y-0 right-0 pr-3 flex items-center text-gray-400 hover:text-gray-600"
                    >
                      {showPassword ? <EyeOff className="h-5 w-5" /> : <Eye className="h-5 w-5" />}
                    </button>
                  </div>
                  {errors.password && <p className="text-red-500 text-sm mt-1">{errors.password}</p>}
                </div>
              </>
            ) : (
              <>
                <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                  <div>
                    <Label htmlFor="firstName" className="text-gray-700">Nombre</Label>
                    <Input id="firstName" name="firstName" type="text" placeholder="Tu nombre" className="mt-1" required />
                    {errors.firstName && <p className="text-red-500 text-sm mt-1">{errors.firstName}</p>}
                  </div>
                  <div>
                    <Label htmlFor="lastName" className="text-gray-700">Apellido</Label>
                    <Input id="lastName" name="lastName" type="text" placeholder="Tu apellido" className="mt-1" required />
                    {errors.lastName && <p className="text-red-500 text-sm mt-1">{errors.lastName}</p>}
                  </div>
                </div>
                <div>
                  <Label htmlFor="email" className="text-gray-700">Correo electrónico</Label>
                  <Input id="email" name="email" type="email" placeholder="tu@ejemplo.com" className="mt-1" required />
                  {errors.email && <p className="text-red-500 text-sm mt-1">{errors.email}</p>}
                </div>
                <div>
                  <Label htmlFor="confirmEmail" className="text-gray-700">Confirmar correo electrónico</Label>
                  <Input id="confirmEmail" name="confirmEmail" type="email" placeholder="tu@ejemplo.com" className="mt-1" required />
                  {errors.confirmEmail && <p className="text-red-500 text-sm mt-1">{errors.confirmEmail}</p>}
                </div>
                <div>
                  <Label htmlFor="password" className="text-gray-700">Contraseña</Label>
                  <div className="relative">
                    <Input 
                      id="password" 
                      name="password"
                      type={showPassword ? "text" : "password"} 
                      placeholder="Tu contraseña" 
                      className="mt-1 pr-10" 
                      required
                    />
                    <button
                      type="button"
                      onClick={togglePasswordVisibility}
                      className="absolute inset-y-0 right-0 pr-3 flex items-center text-gray-400 hover:text-gray-600"
                    >
                      {showPassword ? <EyeOff className="h-5 w-5" /> : <Eye className="h-5 w-5" />}
                    </button>
                  </div>
                  {errors.password && <p className="text-red-500 text-sm mt-1">{errors.password}</p>}
                </div>
                <div>
                  <Label htmlFor="confirmPassword" className="text-gray-700">Confirmar contraseña</Label>
                  <div className="relative">
                    <Input 
                      id="confirmPassword" 
                      name="confirmPassword"
                      type={showConfirmPassword ? "text" : "password"} 
                      placeholder="Confirma tu contraseña" 
                      className="mt-1 pr-10" 
                      required
                    />
                    <button
                      type="button"
                      onClick={toggleConfirmPasswordVisibility}
                      className="absolute inset-y-0 right-0 pr-3 flex items-center text-gray-400 hover:text-gray-600"
                    >
                      {showConfirmPassword ? <EyeOff className="h-5 w-5" /> : <Eye className="h-5 w-5" />}
                    </button>
                  </div>
                  {errors.confirmPassword && <p className="text-red-500 text-sm mt-1">{errors.confirmPassword}</p>}
                </div>
              </>
            )}
            <Button type="submit" className="w-full bg-black text-white hover:bg-gray-800">
              {isLogin ? 'Iniciar sesión' : 'Registrarse'}
            </Button>
          </form>
          {isLogin && (
            <>
              <div className="text-center text-gray-500 my-4">o</div>
              <Button variant="outline" className="w-full border-gray-300 text-gray-700 hover:bg-gray-100">
                <FaGoogle className="mr-2 h-5 w-5" /> Iniciar sesión con Google
              </Button>
            </>
          )}
        </div>
        <p className="text-center mt-4 text-gray-400">
          {isLogin ? "¿No tienes una cuenta? " : "¿Ya tienes una cuenta? "}
          <button
            type="button"
            onClick={() => {
              setIsLogin(!isLogin)
              setErrors({})
            }}
            className="text-white hover:underline"
          >
            {isLogin ? 'Regístrate' : 'Inicia sesión'}
          </button>
        </p>
      </div>
    </div>
  )
}