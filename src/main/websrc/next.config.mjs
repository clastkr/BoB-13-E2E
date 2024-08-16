/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: false,
  async rewrites() {
    return [
      {
        source: '/api/create_key',
        destination: 'http://localhost:8080/api/create_key'
      },
    ]
  },
};

export default nextConfig;
