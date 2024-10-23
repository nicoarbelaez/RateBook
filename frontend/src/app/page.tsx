"use client"

import { useState } from 'react'
import Image from 'next/image'
import { Star, MessageSquare } from 'lucide-react'
import { Button } from "@/components/ui/button"
import { Card, CardContent } from "@/components/ui/card"
import { ScrollArea, ScrollBar } from "@/components/ui/scroll-area"

// Tipos para las props
interface Product {
  title: string
  rating: number
  comments: number
  reviews: number
  image: string
}

interface ProductSectionProps {
  title: string
  products: Product[]
}

// Componente de producto
const ProductCard: React.FC<Product> = ({ title, rating, comments, reviews, image }) => (
  <Card className="w-[250px] bg-gray-100">
    <CardContent className="p-4">
      <Image src={image} alt={title} width={250} height={150} className="w-full h-[150px] object-cover mb-4 rounded" />
      <h3 className="font-semibold mb-2">{title}</h3>
      <div className="flex items-center gap-2 text-sm text-gray-600">
        <div className="flex">
          {[...Array(5)].map((_, i) => (
            <Star
              key={i}
              className={`w-4 h-4 ${i < rating ? 'stroke-yellow-500' : 'stroke-gray-300'}`}
              fill={i < rating ? 'currentColor' : 'none'}
            />
          ))}
        </div>
        <span>{rating}</span>
        <MessageSquare className="w-4 h-4" />
        <span>{comments}</span>
        <span>({reviews} reseñas)</span>
      </div>
    </CardContent>
  </Card>
)

// Componente de sección de productos
const ProductSection: React.FC<ProductSectionProps> = ({ title, products }) => (
  <section className="mb-12">
    <h2 className="text-2xl font-bold mb-4">{title}</h2>
    <ScrollArea className="w-full whitespace-nowrap rounded-md border border-gray-200">
      <div className="flex w-max space-x-4 p-4">
        {products.map((product, index) => (
          <ProductCard key={index} {...product} />
        ))}
      </div>
      <ScrollBar orientation="horizontal" />
    </ScrollArea>
  </section>
)

const Component: React.FC = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false)

  // Datos de ejemplo
  const sections: ProductSectionProps[] = [
    {
      title: "Libros",
      products: [
        { title: "El gran Gatsby", rating: 4, comments: 120, reviews: 98, image: "/placeholder.svg?height=150&width=250" },
        { title: "Cien años de soledad", rating: 5, comments: 200, reviews: 180, image: "/placeholder.svg?height=150&width=250" },
        { title: "1984", rating: 4, comments: 150, reviews: 130, image: "/placeholder.svg?height=150&width=250" },
      ]
    },
    {
      title: "Películas",
      products: [
        { title: "El Padrino", rating: 5, comments: 300, reviews: 250, image: "/placeholder.svg?height=150&width=250" },
        { title: "Pulp Fiction", rating: 4, comments: 280, reviews: 220, image: "/placeholder.svg?height=150&width=250" },
        { title: "Forrest Gump", rating: 4, comments: 260, reviews: 200, image: "/placeholder.svg?height=150&width=250" },
      ]
    },
    {
      title: "Series",
      products: [
        { title: "Breaking Bad", rating: 5, comments: 400, reviews: 350, image: "/placeholder.svg?height=150&width=250" },
        { title: "Juego de Tronos", rating: 4, comments: 500, reviews: 450, image: "/placeholder.svg?height=150&width=250" },
        { title: "Stranger Things", rating: 4, comments: 350, reviews: 300, image: "/placeholder.svg?height=150&width=250" },
      ]
    },
  ]

  return (
    <div className="min-h-screen bg-gray-50">
      <nav className="flex justify-between items-center p-4 bg-white shadow-sm">
        <div className="text-2xl font-bold text-gray-800">Logo</div>
        <div>
          {isLoggedIn ? (
            <Image src="/placeholder.svg?height=40&width=40" alt="Perfil" width={40} height={40} className="w-10 h-10 rounded-full" />
          ) : (
            <div className="space-x-2">
              <Button variant="outline" onClick={() => setIsLoggedIn(true)}>Iniciar sesión</Button>
              <Button variant="outline" onClick={() => setIsLoggedIn(true)}>Registrarse</Button>
            </div>
          )}
        </div>
      </nav>
      <main className="container mx-auto px-4 py-8">
        {sections.map((section, index) => (
          <ProductSection key={index} {...section} />
        ))}
      </main>
    </div>
  )
}

export default Component
